import java.net.*;
import java.io.*;

public class SendPostRequest {
  public static void main(String[] args) throws MalformedURLException, IOException {
    URL reqURL = new URL("http://www.stackoverflow.com/"); //the URL we will send the request to
    HttpURLConnection request = (HttpURLConnection) (reqUrl.openConnection());
    request.setMethod("GET");
    request.connect();

  }
}