public class WebManager {
public MyObject1 getObject1(ResponseListener listener) {
    AsyncHttpClient client = new AsyncHttpClient();

    client.get(QUERY_URL,
            new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(JSONObject jsonObject) {

                     //here's the change
                     listener.onObject1DataDownload(jsonObject);
                }

                @Override
                public void onFailure(int statusCode, Throwable throwable, JSONObject error) {

                    //Call method on my Activity and pass statusCode, throwable and error
                }
            });
}