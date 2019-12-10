package ws_codechallenge;

/*
 * Class Name: CodeRnageHelper.java
 * Class Description: This is a helper class which help main class to encapsulate the Data Structure for Zip Code.
 * @author JLiu <jliu.itcorp@gmail.com>
 */

public class CodeRangeHelper {
	
	/*
	 * Private data type create the Encapsulation which can protect the data
	 */
	private String low_bound;
	private String high_bound;
	
	/*
	 * Default Constructor
	 */
	CodeRangeHelper(){
		this.low_bound = "0";
		this.high_bound = "0";
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.low_bound + "," + this.high_bound;
	}
	
	
	/*
	 * Constructor with two parameter
	 * @param high is the high_bound
	 * @param low is the low_bound
	 */
	CodeRangeHelper(String low, String high){
		this.low_bound = low;
		this.high_bound = high;
	}
	/*
	 * GET and SET methods of two variables.
	 * @param high_bound is the end range of zip code
	 * @param low_bound is the start range of zip code
	 */
	
	/*
	 * @return get value from SET and pass high_bound to main class 
	 */
	public String getLow_bound() {
		return low_bound;
	}
	/*
	 * @param high_bound to SET
	 */
	public void setLow_bound(int low_bound) {
		this.low_bound = Integer.toString(low_bound);
	}
	/*
	 * @return get value from SET and pass low_bound to main class
	 */
	public String getHigh_bound() {
		return high_bound;
	}
	/*
	 * @param low_bound to SET
	 */
	public void setHigh_bound(int high_bound) {
		this.high_bound = Integer.toString(high_bound);
	}

}
