import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class library {

    @Test
    public void api (){
        RestAssured.baseURI = "http://216.10.245.166/";
       String response=  given()
                .header("Content-Type","application/json")
                .body(payload.addBook())
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
       String id = js.get("ID");
       System.out.println("$$$"+id);

       //Test clone
        //Test again
    }


}
