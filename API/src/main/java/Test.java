import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Test {

    @org.testng.annotations.Test
    public void helloo() throws IOException {
//Add place api
        //given - all input details
        //when - Submit the API, resource, http method
        //Then - validate the response
        RestAssured.baseURI = "https://betaapi.assetowner.co/";
        given().log().all()
               // .queryParam("key","qaclick123")

                .auth().preemptive().basic("api","password")
                .header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("/Users/baba/Downloads/Aoapi.json"))))
               /* .body("{\n" +
                        "  \"grant_type\" : \"password\",\n" +
                        "  \"username\": \"admin@assetowner.co\",\n" +
                        "  \"password\": \"qwertyu1\"\n" +
                        "} ")*/
                /*.body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Rahul Shetty Academy\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://rahulshettyacademy.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")*/
                .when().post("oauth/token")
                .then().log().all().assertThat().statusCode(200);
    }

}
