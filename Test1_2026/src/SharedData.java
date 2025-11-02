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
	/** A flag indicating whether a valid solution has been found */
	private boolean flag;
	/** The target value to reach by combining elements */
	private final int b;
	
	/** Constructs a new instance
	 * @param array    the list of integers to be processed
	 * @param b     the target value to reach
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/** Returns the list of boolean values representing the winning subset
	 * @return  indicating which elements are part of the solution
	 */
	public ArrayList<Boolean> getWinArray() {
        return winArray;
    }

    /** Sets the winning subset list
     * @param winArray an indicating which elements are part of the solution
     */
    public void setWinArray(ArrayList<Boolean> winArray) {
        this.winArray = winArray;
    }

    /** Returns the list of integers being processed.
     * @return array containing the numbers
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

	/** Returns the target value.
     * @return the target value b
	 */
	public int getB() 
	{
		return b;
	}

	/** Returns the shared flag indicating whether a valid solution has been found.
     * @return  if a solution was found
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/** Sets the shared flag value.
     * @param flag if a solution was found
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
