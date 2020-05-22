import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

@Slf4j
public class JsonTest {
    @Test
    public void test() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://jsonblob.com/api/jsonBlob/537a43bfe4b047fa2ef5f15d");
        request.addHeader("accept", "application/json");
        HttpResponse response = client.execute(request);
        String json = IOUtils.toString(response.getEntity().getContent());
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            log.info("the id is {}", object.getInt("id"));
            log.info("the insertDate is {}", object.getString("insertDate"));
            log.info("read is {}", object.getBoolean("read"));
            log.info("the site is {}", object.getString("site"));
            log.info("the Email is {}", object.getString("Email"));
            log.info("the location is {}", object.getString("location"));
        }
    }
}