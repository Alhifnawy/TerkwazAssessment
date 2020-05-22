package listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testsAPI.API_TestBase;

import java.util.Arrays;

public class CustomListeners extends API_TestBase implements ITestListener {

	public static String resultAttributeNames;
	public static String[] resultAttributeName;

	public void onTestStart(ITestResult result) {
		resultAttributeName = Arrays.copyOf(result.getParameters(), result.getParameters().length, String[].class);
		resultAttributeNames = Arrays.toString(resultAttributeName);

		if (resultAttributeName.length != 0) {
			RepoNode = test.createNode("Testing the " + result.getName() + resultAttributeNames + " <br>");
			log.debug("Testing the " + result.getName() + resultAttributeNames);
		} else
			RepoNode = test.createNode("Testing the " + result.getName() + " <br>");
			log.debug("Testing the " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		RepoNode.log(Status.PASS, "The " + result.getName() + resultAttributeNames + " <br> PASSED<br>");
		log.debug("The " + result.getName() + " Test\n" + resultAttributeNames + "\n  PASSED");

	}

	public void onTestFailure(ITestResult result) {
		RepoNode.fail("The " + result.getName() + " Test"
				+ resultAttributeNames + " <br> FAILED <br>" + "The Test Exception : <br>" + result.getThrowable());
		
		log.debug("The " + result.getName() + " Test\n "
				+ resultAttributeNames + "\n  FAILED \n" + "The Test Exception : \n" + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		test = extent.createTest(context.getName());
		test.log(Status.INFO, "The " + context.getName() + "  Starting ... <br>");
		log.debug("The " + context.getName() + " Starting ... ");
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		log.debug("The " + context.getName() + " Finished ... ");
	}

}
