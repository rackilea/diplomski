import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

...

DefaultHttpClient httpClient = new DefaultHttpClient();
HttpGet httpGet = new HttpGet("http://www.google.com");
httpGet.addHeader("MyHeader", "MyValue");

try {
    String body = httpClient.execute(httpGet, new ResponseHandler<String>() {

        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            Header firstHeader = response.getFirstHeader("MyHeader");
            String headerValue = firstHeader.getValue();
            return EntityUtils.toString(response.getEntity());
        }
    });
} catch (IOException e) {
    e.printStackTrace();
}