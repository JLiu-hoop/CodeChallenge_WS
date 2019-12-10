package ws_codechallenge;

/*
 * Logic class of Coding Challenge, there are FIVE main methods to implement the requirement:
 * 1. read_csv() which read the input file. In this case, the format of files are CSV
 * 2. sort_range() which sort the input range in order
 * 3. check_code() which check if the input value is valid.
 * 4. merge_range() which merge ranges which have overlap parts with each other
 * 5. putinto_file() which write in the new ranges into files. In this case, the format of files are CSV
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * @author JLiu <jliu.itcorp@gmail.com>
 */

public class CodeRange {
	
	/*
	 * isOverlap method can check the two intervals zip code range, and it can re-usable and call from other class
	 * @param str1 and str2 both are two Objects declared in CodeRangeHelper type.
	 */
	public boolean isOverlap (CodeRangeHelper str1, CodeRangeHelper str2) {
		if(Integer.parseInt(str1.getHigh_bound()) >= Integer.parseInt(str2.getLow_bound()))
			return true;
		return false;
	}
	
	/*
	 * merge method which helps to determine the merged zip range's low bound and high bound based on two overlapping intervals 
	 * @param input1 and input2 both are two Objects declared in CodeRangeHelper type
	 */
	public CodeRangeHelper merge(CodeRangeHelper input1, CodeRangeHelper input2){
		CodeRangeHelper tmp = new CodeRangeHelper();
		/*
		 * use Math.min() and Math.max() method to determine the low bound and high bound
		 * if two intervals are overlapping with each other, the the merged range's low bound should be the min((the low bound of bigger range), (the high bound of smaller range))
		 * if two intervals are overlapping with each other, the the merged range's high bound should be the max((the high bound of bigger range), (the high bound of smaller range))
		 */
		tmp.setLow_bound(Math.min(Integer.parseInt(input1.getLow_bound()), Integer.parseInt(input2.getLow_bound())));
		tmp.setHigh_bound(Math.max(Integer.parseInt(input1.getHigh_bound()), Integer.parseInt(input2.getHigh_bound())));
		return tmp;
	}
	
	/*
	 * sortRange method which helps unsorted zip range input into sorted one so that it's easy to determine and merge
	 * @param rangeList is the the list of all data in (xxxxx,xxxxxx) format
	 */
	
	public void sortRange(ArrayList<CodeRangeHelper> unsorted_range) {
		// Collections.sort(list, flag)
		// is the common method is used to sort the list of object depends on the flag
		// flag = 1, then is the ascending order
		// flag = 0, then means the two elemets in list are equals with each other
		// flag = -1, then is the descending order
		Collections.sort(unsorted_range, new Comparator<CodeRangeHelper>() {
			/*
			 * (non-Javadoc)
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
			 */
			@Override
			public int compare(CodeRangeHelper range1, CodeRangeHelper range2) {
				String r1 = range1.getLow_bound();
				String r2 = range2.getLow_bound();
				int comp = r1.compareTo(r2);

				if (comp != 0) {
					return comp;
				} else {
					String R1 = ((CodeRangeHelper) range1).getHigh_bound();
					String R2 = ((CodeRangeHelper) range2).getHigh_bound();
					return R1.compareTo(R2);
				}
			}
		});
	}
	
	/*
	 * merge_range method which is the main method which implement the merge two overlapping interval
	 * @param before_merge is the unsorted and unmerged list of data in (xxxxx,xxxxx) format
	 */
	public ArrayList<CodeRangeHelper> merge_range(ArrayList<CodeRangeHelper> before_merge){
		
		ArrayList<CodeRangeHelper> merged = new ArrayList<CodeRangeHelper>();
		// call sortRange() method here
		sortRange(before_merge);
		
		CodeRangeHelper tmp = before_merge.get(0);
		for(int i = 1; i < before_merge.size(); i++){
			// Call isOverlap() method here
			 if(isOverlap(tmp, before_merge.get(i))){
				 // call merge() method here
				 tmp = merge(tmp, before_merge.get(i));
			 } else {
				 merged.add(tmp);
				 tmp=before_merge.get(i);
			 }
		}
		merged.add(tmp);
		return merged;
	}

	/*
	 * runnable method is the executable method which is executed by text_case class and call the previous methods to implement the task.
	 * @param input is the name of input file
	 * @param output is the name of output file
	 */
	public ArrayList<CodeRangeHelper> runnable(String input, String output){
		OutputIntoFiles oi = new OutputIntoFiles();
		ReadInputFile ri = new ReadInputFile();
		ArrayList<CodeRangeHelper> rangeList = new ArrayList<CodeRangeHelper>();
		ArrayList<CodeRangeHelper> read_range = ri.read_csv(input);
		rangeList = merge_range(read_range);
		oi.putinto_file(rangeList, output);
		System.out.println("Done. Please Check output file");
		return rangeList;
	}
	
/*
 * Main method for the sample testing during coding
 */
//	public static void main(String[] args) {
//		ArrayList<CodeRangeHelper> list = read_csv("resources/input/input0.csv");
////		System.out.print(list); 
////		merge_range(list);
//		System.out.print(merge_range(list));
//	}
}
