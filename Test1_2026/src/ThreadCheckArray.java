import java.util.ArrayList;

public class ThreadCheckArray implements Runnable 
{
	private boolean flag;
	 private ArrayList<Boolean> winArray;
	SharedData sd;
	private ArrayList<Integer> array;
	int b;
	
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray();
			b = sd.getB();
		}		
		winArray = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            winArray.add(false);
        }
	}
	
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			if (b == 0 || b == array.get(n - 1))
			{
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			if (b == array.get(n - 1))
                winArray.set(n - 1, true);
			return;
		}
		
		rec(n - 1, b - array.get(n - 1));
		if (flag)
			winArray.set(n - 1, true);
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}

	public void run() {
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				 rec(array.size() - 1, b - array.get(array.size() - 1));
			else 
				rec(array.size() - 1, b);
		if (array.size() == 1)
			if (b == array.get(0) && !flag)
			{
				winArray.set(0, true);
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				winArray.set(array.size() - 1,true);
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
	}
}
