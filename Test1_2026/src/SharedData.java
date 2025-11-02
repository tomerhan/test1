import java.util.ArrayList;

/** class represents a shared object used for communication
 * and synchronization between multiple threads
 * @author Linoy
 * @version 1.0
 */
public class SharedData 
{
	/** List of numbers being worked on */
	private ArrayList<Integer> array;
	/** A list indicating which members participate in the winning solution */
	private ArrayList<Boolean> winArray;
	/** A flag indicating whether a valid solution has been fou */
	private boolean flag;
	private final int b;
	
	/** jbhkbnkbnknbkbj
	 * @param array     hvgvg
	 * @param b    nvhbjv
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/**
	 * @return
	 */
	public ArrayList<Boolean> getWinArray() {
        return winArray;
    }

    /**
     * @param winArray
     */
    public void setWinArray(ArrayList<Boolean> winArray) {
        this.winArray = winArray;
    }

    /**
     * @return
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

	/**
	 * @return        b
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * @return      flag
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
