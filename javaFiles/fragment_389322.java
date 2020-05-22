import java.net.*;
import java.io.*;
public class SendPostRequest {
  public static void main(String[] args) throws MalformedURLException, IOException {
    URL reqURL = new URL("http://www.stackoverflow.com/"); //the URL we will send the request to
    HttpURLConnection request = (HttpURLConnection) (reqUrl.openConnection());
    String post = "this will be the post data that you will send"
    request.setDoOutput(true);
    request.addRequestProperty("Content-Length", Integer.toString(post.length)); //add the content length of the post data
    request.addRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //add the content type of the request, most post data is of this type
    request.setMethod("POST");
    request.connect();
    OutputStreamWriter writer = new OutputStreamWriter(request.getOutputStream()); //we will write our request data here
    writer.write(post);
    writer.flush();
  }
}