import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.mime.HttpMultipartMode;



public class PostFile {
  public static void main(String[] args) throws Exception {

    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpPost httppost = new HttpPost("http://XXXXX.XXX.XXXXXX.XXX/XX/XXXXXXX/XX/XXXXXXX/XXXXXXX");

    RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
    .setProxy(new HttpHost("XXX.XXX.XXX.XXX", 8080))
    .build();
    httppost.setConfig(requestConfig);

    httppost.addHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");

    File file = new File("batch2.txt");

    FileEntity entity = new FileEntity(file);

    httppost.setEntity(entity);

    System.out.println("executing request " + httppost.getRequestLine() + httppost.getConfig());
    HttpResponse response = httpclient.execute(httppost);
    HttpEntity resEntity = response.getEntity();

    System.out.println(response.getStatusLine());
    if (resEntity != null) {;
      System.out.println(EntityUtils.toString(resEntity));
    }

    httpclient.close();
  }
}