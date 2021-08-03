package seralization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class seliseTest {
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

       // ap.setLoaction(lo);

       Response res= given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json;charset=UTF-8").queryParams("key", "qaclick123")


                .body(p)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(res.getStatusCode());
        System.out.println("@@@@@"+res.asString());

    }
}
