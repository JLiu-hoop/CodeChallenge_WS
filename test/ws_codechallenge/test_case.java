package ws_codechallenge;
import java.io.File;
/*
 * Test Class: test_case
 * Description: test_case is a test class for srouce code which includes three methods
 * @param  before is the method to read the expected output from file called output.csv
 * @param testCase is the method to run the unit test on source code using test case file called input.csv and compare to the expected one
 * @After after is the method to close the test case
 */
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/*
 * @Author JLiu <jliu.itcorp@gmail.com>
 */
@RunWith(JUnit4.class)
public class test_case {
	
	// Give different test cases path here
	CodeRange runnable;
	OutputIntoFiles oi;
	ReadInputFile ri;
	String expected = "resources/expected/output.csv";
	String outBound = "resources/errors/outbound.csv";
	String outBoundOutput = "resources/errors/outbound.csv";
	String alpinput = "resources/errors/alpinput.csv";
	String alpoutput = "resources/errors/alpoutput.csv";
	String emptyinput = "resources/errors/emptyinput.csv";
	String emptyoutput = "resources/errors/emptyoutput.csv";
	String raninput = "resources/errors/raninput.csv";
	String ranoutput = "resources/errors/ranoutput.csv";
	String input = "resources/input/input.csv";
	String actual = "resources/actual/actual.csv";
	
	// Define two reusable valuable here
	ArrayList<CodeRangeHelper> expected_output;
	ArrayList<CodeRangeHelper> actuals_output;	
	
	@Test
	public void empty_range_test() throws Exception {
		System.out.println("This is a test for empty input: ");
		expected_output = new ArrayList<CodeRangeHelper>();
		actuals_output = new ArrayList<CodeRangeHelper>();
		actuals_output = ri.read_csv(emptyinput);
		Assert.assertEquals(expected_output, actuals_output );
	}
	
	@Ignore
	public void random_input_test() {
		System.out.println("This is a test for random input: ");
		actuals_output = new ArrayList<CodeRangeHelper>();
//		mergedActuals = runnable.runnable(raninput, ranoutput);
	}
	
	@Test
	public void alphabet_input_test(){
		System.out.println("This is a test for alphabet input: ");
		actuals_output = new ArrayList<CodeRangeHelper>();
		actuals_output = runnable.runnable(alpinput, alpoutput);
		Assert.assertEquals(actuals_output, null);
	}
	
	@Test
	public void outbound_test(){
		System.out.println("This is a test for outbound input: ");
		expected_output = new ArrayList<CodeRangeHelper>();
		actuals_output = new ArrayList<CodeRangeHelper>();
		actuals_output = ri.read_csv(outBound);
		Assert.assertEquals(expected_output, actuals_output);
	}
	
	@Test
	public void testCase() {
		actuals_output = new ArrayList<CodeRangeHelper>();
		actuals_output = runnable.runnable(input, actual);
		for (int i = 0; i < actuals_output.size(); i++) {
			Assert.assertEquals(expected_output.get(i).toString(), actuals_output.get(i).toString());
		}
	}
	
	
	@Before
	public void before(){
		runnable = new CodeRange();
		ri = new ReadInputFile();
		expected_output = new ArrayList<CodeRangeHelper>();
		expected_output = ri.read_csv(expected);
	}
	
	@After
	public void after() {
		runnable = null;
		expected = null;
	}
	
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("The first class will be executed before test!");
	}
	
	@AfterClass
	public static void testAfterCLass() {
		System.out.println("Everytime exected the test case will execute this class!");
	}
}
