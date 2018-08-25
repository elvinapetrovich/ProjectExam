package restTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import restSteps.MainRestSteps;

public class UvoApiTest {
MainRestSteps mainRestSteps=new MainRestSteps();
Logger logger=Logger.getLogger(getClass());
    @Test
    public void restTest(){
        try {
            RestAssured.baseURI = "https://www.uvocorp.com/contractor_profile/api";
            RequestSpecification httpRequest = RestAssured.given().auth().basic("client-api", "2xpZW50LWFwa");
            Response response = httpRequest.request(Method.GET, "/policies");
            mainRestSteps.checkResponseCode(response, 200);
            logger.info("Expected status code");
            System.out.println("Body " + response.getBody().asString());
            logger.info("Active policy received");
        } catch (Exception e){
            logger.error("Couldn't get active policy");
            Assert.fail("Couldn't get active policy");
        }

    }
}
