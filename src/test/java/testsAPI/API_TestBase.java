package testsAPI;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class API_TestBase {
	public static Properties API_Resources = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public ExtentReports extent = ExtentRepoManager.getInstance();
	public static ExtentTest test;
	public static ExtentTest RepoNode;

	@BeforeSuite
	public void setUp() {
		log.debug(" ## Suite Test Execution Starts ## ");
		
			try {
				log.debug("Open file Stream for the API_Resources.properties file ");
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\API_Resources.properties");
				log.debug("Open file Stream loaded Successfully");
			} catch (FileNotFoundException e) {
				log.fatal("Open file Stream FAILED with exception /n " + e.getMessage());
				e.printStackTrace();
			}
			try {
				log.debug("Reading the properties from the API_Resources.properties file stream ");
				API_Resources.load(fis);
				log.debug("Reading the properties completed successfully");
			} catch (IOException e) {
				log.fatal("Reading the properties FAILED with exception /n " + e.getMessage());
				e.printStackTrace();
			}

			log.debug("Setting the Base URI for the Rest Assured to : " + API_Resources.getProperty("BaseURL"));
			RestAssured.baseURI=API_Resources.getProperty("BaseURL");

		}

	@AfterSuite
	public void tearDown() {
		try {
			log.debug("Close the file Stream ");
			fis.close();
			log.debug("Closing the file Stream completed successfully ");
		} catch (IOException e) {
			log.fatal("Closing the file Stream FAILED with exception /n " + e.getMessage());
			e.printStackTrace();
		}
		log.debug(" ## Suite Test Execution Completed ##");
	}


}
