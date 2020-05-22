import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class ValidateURL {


    public static void main(String[] args) {

        String urlString = "https://www.google.com";

        // Make sure "http://" or "https://" is located
        // at the beginning of the supplied URL.
        if (urlString.matches("((http)[s]?(://).*)")) {
            try {
                final URL url = new URL(urlString);
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                int responseCode = huc.getResponseCode();
                if (responseCode != 200) {
                    System.out.println("There was a problem connecting to:\n\n" + 
                            urlString + "\n\nResponse Code: [" + responseCode + "]");
                }
                System.out.println("The supplied URL is GOOD!"); 
            }  
            catch (UnknownHostException | MalformedURLException ex) { 
                System.out.println("Either the supplied URL is good or\n" + 
                        "there is No Network Connection!\n" + urlString);
            } 
            catch (IOException ex) { 
                System.out.println(ex.getMessage());
            }

        }
    }
}