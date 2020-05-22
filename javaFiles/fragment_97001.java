import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by arcseldon on 07/09/2016.
 */
public class GetUsers {

    public static void main(String[] args) throws IOException {

        final String MANAGEMENT_TOKEN = "YOUR_MANAGEMENT_TOKEN";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://<YOUR_TENANT>.auth0.com/api/v2/users")
                .get()
                .addHeader("authorization", "Bearer " + MANAGEMENT_TOKEN)
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("All done: " + response.body().string());
    }
}