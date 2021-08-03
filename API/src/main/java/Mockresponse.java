import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class Mockresponse {

@Test
    public void iterateapis() {
        String response = "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}\n" +
                "\n";
        JsonPath js = new JsonPath(response);
        // print no of courses returned by API
       int count = js.getInt("courses.size()");
       System.out.println("#####Count :"+count);
       int purchase_amaount = js.getInt("dashboard.purchaseAmount");
    System.out.println("#####purchase amaount :"+purchase_amaount);
    //js.get is by default a string
    String firstTitle= js.get("courses[0].title");
    System.out.println("#####first Title :"+firstTitle);

    //print all course  titles and price
    int totalprice=0;
    for(int i=0;i<count;i++){
        if(js.get("courses["+i+"].title").equals("RPA"))
            System.out.println("#####%%%%% Price of RPA ="+js.getInt("courses["+i+"].price"));
        System.out.println("#####Title :"+js.get("courses["+i+"].title"));
        int price = js.getInt("courses["+i+"].price");
        int copies = js.getInt("courses["+i+"].copies");
        System.out.println("#####Price :"+js.getInt("courses["+i+"].price"));
        int actualprice = price*copies;
        totalprice =totalprice +actualprice;
        System.out.println();
    }
    System.out.println("#####Price : "+totalprice);
    }
}
