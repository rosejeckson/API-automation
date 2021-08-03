import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pojo.Courses;
import pojo.Getcourse;

import java.lang.reflect.Array;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class pojoexecution {
    String accesToken;

    @Test
    public void auth() {
        //WebDriverManager.chromedriver().setup();
        //ChromeDriver driver =  new ChromeDriver();
        // driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWguTRwaqpMzRBSU6QjXu__a3tdyHz5XQXY-vnN21nMe-XjKBRbzmudxlNqButhvlA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";


        String partialcode = url.split("code=")[1];

        String code = partialcode.split("&scope")[0];

        System.out.println(code);

        String response =

                given()

                        .urlEncodingEnabled(false)

                        .queryParams("code", code)


                        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .queryParams("grant_type", "authorization_code")

                        .queryParams("state", "verifyfjdss")

                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

                        // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")


                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

                        .when().log().all()

                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        accesToken = js.getString("access_token");

    }
    @Test
    public void auth1() {
        System.out.println("@@@@@@@@@@"+"accesToken");
        //should tell restassured to expect repsonse in json
        Getcourse response2 = given().relaxedHTTPSValidation().queryParam("access_token","ya29.a0ARrdaM9gOTv0HwxOtLdP5IlTFimTMJUDRWeKTmUyR3mI7n_qpgw91Dirh5f1w-u-QumBbRnihLFuksCTvt8viyajXWg-stSUec9Ey3EiA4eHNRMfDL0sdsqIK3rpJyH_d4RouPc5j8NAPmlYq0vVZiEtA9oPtw")
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").as(Getcourse.class);
        //System.out.println("@@@@@@@@@@"+response2);
        System.out.println(response2.getInstructor());
        System.out.println(response2.getCourses().getApi().get(1).getCourseTitle());
        int apisize = response2.getCourses().getApi().size();
        for(int i=0;i<apisize;i++){
            if (response2.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
                System.out.println(response2.getCourses().getApi().get(i).getPrice());
            else{

            }

        }


    }
}
