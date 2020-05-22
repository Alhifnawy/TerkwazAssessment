package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentRepoManager {
	
	private static ExtentReports extent ;

	//Location of the extent report
	private static String ExtentRepoPath=System.getProperty("user.dir") + "/test-output/ExtentReport.html";

	public static ExtentReports getInstance() {

		if( extent == null) {
			 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ExtentRepoPath);
			 extent = new ExtentReports();
			 extent.attachReporter(htmlReporter);

			// General information related to application
			 extent.setSystemInfo("OS", "Windows 10");
			 extent.setSystemInfo("Tester Name", "Abdurahman Alhifnawy");
			 extent.setSystemInfo("Environment", "Production");

			htmlReporter.config().setDocumentTitle("Terkwaz Assessment"); // Title of Report
			htmlReporter.config().setReportName("Automation Report"); // Name of the report
			htmlReporter.config().setTheme(Theme.DARK); //Default Theme of Report
		}
		return extent ;
	}
}
