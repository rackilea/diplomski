...
import com.facebook.react.modules.network.OkHttpClientProvider;
...

public class MainActivity extends ReactActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachInterceptor();
    }

    private void attachInterceptor() {
        OkHttpClient client = OkHttpClientProvider.getOkHttpClient();
        client.networkInterceptors().add(new CustomInterceptor());
    }
}