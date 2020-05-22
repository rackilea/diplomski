import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

protected void doGet(HttpServletRequest req, HttpServletResponse resp)
{
   String url="http://your.server.com/path/to/app?par1=yxc&par2=abc");
   HttpGet get=new HttpGet(url);
   httpClient = HttpClients.createDefault();
   // optional configuration
   RequestConfig config=RequestConfig.custom().setSocketTimeout(socketTimeoutSec * 1000).build();
    // more configuration

    get.setConfig(config);

    CloseableHttpResponse internResponse = httpClient.execute(get);

    int internResponseStatus = internResponse.getStatusLine().getStatusCode();

    InputStream respIn = internResponseEntity.getContent();
    String contentType = internResponseEntity.getContentType().getValue();

    // consume the response
}