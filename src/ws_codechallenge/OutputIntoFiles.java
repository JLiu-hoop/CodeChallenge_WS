package ws_codechallenge;
/*
 * OutputIntoFiles is the class which designed to output data into file to output files
 * putinto_file() which write in the new ranges into files. In this case, the format of files are CSV
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @author JLiu <jliu.itcorp@gmail.com>
 */
public class OutputIntoFiles {
	/*
	 * putinto_file is the method which print the data into csv file and stored in specified folder.
	 * @param list is the sorted and merged list of data which will be wrote into target csv file.
	 * @param fileName is the name of target csv file.
	 */
	public void putinto_file(ArrayList<CodeRangeHelper> list, String fileName) {
		FileWriter writer = null;
		// write the file is the most important part which need to use exception function here
		// IOException is the most import exception need to care about
		try {
			writer = new FileWriter(fileName);
		} catch(IOException io) {
			io.printStackTrace();
		}
		if(list.size()>0) {
			for(CodeRangeHelper range : list) {
				try {
					writer.write(range.toString() + "\n");
				} catch(IOException io) {
					io.printStackTrace();
				}
			}
		} try {
			writer.close();
		} catch(IOException io) {
			io.printStackTrace();
		}
	}
}
