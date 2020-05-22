package testsAPI;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class RandomCatFact extends API_TestBase {

	@Test
	void TextFieldNotEmpty() {
		// Create a request object
		RequestSpecification httpsReq = RestAssured.given().contentType(ContentType.JSON).params("animal_type", "cat",
				"amount", "1");

		RepoNode.log(Status.INFO, "Create a request object");
		log.debug("Create a request object");

		//Get the Response
		Response resData = httpsReq.request(Method.GET, API_Resources.getProperty("Endpoints_RetrieveFacts") + "/random");
		
		RepoNode.log(Status.PASS,"asd");
		log.debug("Get the Response");

		String myStr = resData.getBody().prettyPrint();
		
		RepoNode.log(Status.INFO, "The Response body : <br>" + myStr);
		log.debug("The Response body : \n" + myStr);
		
		int actualStatusCode = resData.getStatusCode();
		RepoNode.log(Status.INFO, "The Status Code : <br>" + actualStatusCode);
		log.debug("The Actual Status Code : " + actualStatusCode);
		assertEquals(actualStatusCode, 200);
		log.debug("Assertion PASSED");
		String myText = resData.getBody().jsonPath().get("text");
		
		log.debug("The text in the JSON :: " + myText);
		assertFalse(myText.isEmpty());
		log.debug("Assertion PASSED");

	}

}
