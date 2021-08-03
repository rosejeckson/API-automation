import java.util.concurrent.ThreadLocalRandom;

public class payload {


    public static String addBook(){
        String payload = "{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"bcd\",\n" +
                "\"aisle\":\""+random()+"\",\n" +
                "\"author\":\"John foer\"\n" +
                "}";
        return payload;
    }

    public static int random(){
        int randomNum = ThreadLocalRandom.current().nextInt(999, 9999);
        return randomNum;
    }
}
