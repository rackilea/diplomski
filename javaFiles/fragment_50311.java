import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

HttpClient client = HttpClientBuilder.create().build();
HttpGet get = new HttpGet("https://storage.googleapis.com/videos12/dummy.txt");
HttpResponse response = client.execute(get);
SampleResult.setResponseCode(String.valueOf(response.getStatusLine().getStatusCode()));
SampleResult.setResponseMessage(response.getStatusLine().getReasonPhrase());
HttpEntity entity = response.getEntity();
SampleResult.setBodySize(Math.round(entity.getContentLength()));
EntityUtils.consume(entity);