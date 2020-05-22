// Imports required
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public static void main(String[] args) throws IOException {
    OkHttpClient okHttpClient = new OkHttpClient();
    Request request = new Request.Builder()
            .url("http://data.bitcoinity.org/chart_data")
            .build();
    Response response = okHttpClient.newCall(request).execute();
    JSONObject responseBody = new JSONObject(response.body().string());
    JSONArray aggregated = responseBody.getJSONObject("data_additional")
            .getJSONArray("aggregated");
    for (int i = 0; i < aggregated.length(); ++i) {
        JSONObject rowInfo = aggregated.getJSONObject(i);
        System.out.println(rowInfo.getString("key") + ", " + rowInfo.getDouble("agg") + ", " + rowInfo.getString("share"));
    }
}