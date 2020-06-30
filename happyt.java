import com.cnb.web.driver.factory.DriverFactory;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.testng.asserts.SoftAssert;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class HappyClass extends DriverFactory {


    /**
     * Happy Returns exercise
     */
    public boolean happyTest() throws Exception {
        SoftAssert softAssert = new SoftAssert();
//        String browser = chrome;
        //     WebDriver driver = DriverFactory.getDriver(browser);
        URL happyUrl = new URL("https://happyreturnsqatest.free.beeceptor.com/getProductVariants");
        java.lang.String inputString = null;
        HttpURLConnection connection = (HttpURLConnection) happyUrl.openConnection();
        connection.setRequestMethod("Get");
        int responseCode = connection.getResponseCode();
        //Invoke the endoint, inject the results into a buffer
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((inputString = in.readLine()) != null) {
                response.append(inputString);
            }
            in.close();
        } else {
            return false;
        }

        //Create an array of the resultset by variant
        java.lang.String[] arrayOfVariants = inputString.split("/},/\c");
//This is as far as I got. I had not IDE, so I had to set that up.
// I was expecting an app to do this. I do not have an IDE on my home computer.
// I was constructing the regex when my time ended.
// The next step would be to set up the POST parameters, then select one of the arrayOfVariants to send in the POST.
        return true;
    }

}