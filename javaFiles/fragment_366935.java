import com.example.android_client.models.Deal;
    import com.google.gson.Gson;
    import org.jetbrains.annotations.NotNull;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    import okhttp3.Call;
    import okhttp3.Callback;
    import okhttp3.OkHttpClient;
    import okhttp3.Request;
    import okhttp3.Response;
    import okhttp3.ResponseBody;

        public class Repository {

        private static Repository instance;
        private ArrayList<Deal> dealsList = new ArrayList<>();
        private final OkHttpClient client = new OkHttpClient();
        private MutableLiveData<List<Deal>> _deals = new MutableLiveData<>();                         
        private LiveData<List<Deal>> deals = _deals


        public static Repository getInstance() {
            if(instance == null) {
                instance = new Repository();
            }
            return instance;
        }

        private Repository() {}

        public LiveData<List<Deal>> getDeals() {
            setDeals();
            return deals;
        }

        private void setDeals() {
            Request request = new Request.Builder()
                    .url("http://10.0.2.2:8000/api/deals?<params here>")
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    try (ResponseBody responseBody = response.body()) {
                        if (!response.isSuccessful()) {
                            throw new IOException("Unexpected code " + response);
                        }
                        String jsonDeals = responseBody.string(); // can only call string() once or you'll get an IllegalStateException
                        Deal[] deals = new Gson().fromJson(jsonDeals, Deal[].class);
                        dealsList = new ArrayList<>(Arrays.asList(deals));
                        _deals.setValue(dealsList);

                    }
                }
            });

        }

}
When