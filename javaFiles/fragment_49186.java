import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.File;

public class App 
{
    public static void main( String[] args )
    {
        File sourceZipFile = new File("webjob.zip");
        String kuduApiUrl = "https://yoursitename.scm.azurewebsites.net/api/zip/site/wwwroot/app_data/jobs/triggered/job988/";

        HttpEntity httpEntity = EntityBuilder.create()
        .setFile(sourceZipFile)
        .build();

        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
            "$yoursitename", "SiteLevelPasSw0rD"
        );
        provider.setCredentials(AuthScope.ANY, credentials);

        HttpClient client = HttpClientBuilder.create()
            .setDefaultCredentialsProvider(provider)
            .build();

        HttpPut putRequest = new HttpPut(kuduApiUrl);
        putRequest.setEntity(httpEntity);
        // Kudu's Zip API expects application/zip
        putRequest.setHeader("Content-type", "application/zip");

        try {
            HttpResponse response = client.execute(putRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String resBody = EntityUtils.toString(entity, "UTF-8");
            System.out.println(statusCode);
            System.out.println(resBody);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}