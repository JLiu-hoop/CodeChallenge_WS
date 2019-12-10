package ws_codechallenge;
/*
 * ReadInputFile is the class which designed to read file from input files
 * read_csv() which read the input file. In this case, the format of files are CSV
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @author JLliu <jliu.itcorp@gmail.com>
 */
public class ReadInputFile {
	/*
	 * read_csv method read all the data in input_file
	 * @param FileName is the file name of input file
	 */
	public ArrayList<CodeRangeHelper> read_csv(String FileName){
		String lines;
		ArrayList<CodeRangeHelper> container = new ArrayList<CodeRangeHelper>();
		BufferedReader br = null;
		File input_file = new File(FileName);
		if(input_file.length() == 0) {
			return null;
		}
		// write the file is the most important part which need to use exception function here
		// IOException is the most import exception need to care about
		// Also the fileNotFoundException is the another one need to care about
		else {
		try {

			FileReader input = new FileReader(FileName);
			br = new BufferedReader(input);
			try {
				// Since lines is defined as String, so we can use readLine() function here.
				while((lines = br.readLine())!=null) {
					// range_inline is the String array which collects the low and high bound of single range and split by ","
					String[] range_inline = lines.split(",");
					// here use check_code() method to check if the input data is valid
						if(check_code(Integer.parseInt(range_inline[0])) && check_code(Integer.parseInt(range_inline[1]))  && alp_check(range_inline))
						{
							CodeRangeHelper range = new CodeRangeHelper();
							// use ternary operator here to determine the low bound and high bound of single zip code range
							range = (Integer.parseInt(range_inline[0]) <= Integer.parseInt(range_inline[1])) ? new CodeRangeHelper(range_inline[0], range_inline[1]) :new CodeRangeHelper(range_inline[1], range_inline[0]);
							container.add(range);
						}

					}
				br.close();
				} catch (IOException io)
				{
					io.printStackTrace();
				}

			} catch (FileNotFoundException fn){
			fn.printStackTrace();
		}
			return container;
		}
	}
	/*
	 * check_code method help read_csv to check if the input data is valid
	 * @param zip is the input data which is int type
	 */
	public boolean check_code(int zip) {
		if(zip > 99999 || zip < 10000)
			return false;
		else
			return true;
	}
	
//	public int code_format(CodeRangeHelper range) {
//		if()
////	}
//	
	/*
	 * alp_check method is using RE to check if the input data have alphabet character
	 * @param range is the String Array which contains the two input value
	 */
	public boolean alp_check(String[] range) {
		return (range[0] != null && range[0].matches("^[a-zA-Z0-9]*$") && range[1] != null && range[1].matches("^[a-zA-Z0-9]*$"));
	}
}
