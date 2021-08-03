package seralization;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Specbuilder {
    @Test
    public void testseralisation(){
        RestAssured.baseURI ="https://rahulshettyacademy.com";
        addplace p = new addplace();
        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen 09");
        p.setLanguage("French-IN");
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName("Frontline house");
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        location l= new location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);

// Request spec builder for request
RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam( "key", "qaclick123").setContentType(ContentType.JSON).build();

// Response spec builder  for response
ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();


//Request part
       RequestSpecification res= given().relaxedHTTPSValidation().spec(req).body(p);

//Response part
       Response  res1 =   res.when().post("/maps/api/place/add/json")
                .then().spec(response).extract().response();
        System.out.println(res1.getStatusCode());
        System.out.println("@@@@@"+res1.asString());

    }
}
