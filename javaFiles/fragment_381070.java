import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.vasyaevstropov.oauthtest.ucoz.UcozApi;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button button;
    public WebView webView;
    String verifier;
    OAuth1RequestToken requestToken = null;
    OAuth10aService service;
    OAuth1AccessToken accessToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        service = new ServiceBuilder("murka1")
                .apiSecret("DqUQJzeCPmwD9CRqbHo6sGBzKCb5U4")
                .debug()
                .build(UcozApi.instance());

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, String>() {
                    protected String doInBackground(Void... params) {
                        String PROTECTED_RESOURCE_URL = "http://artmurka.com/uapi/shop/request?page=categories";
                        try {
                            requestToken = service.getRequestToken();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        String url = service.getAuthorizationUrl(requestToken);
                        return url;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        loadURL(result);
                    }
                }.execute();
            }
        });
    }

    public void loadURL(final String url) {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                if (url.contains("oauth_verifier")) {
                    webView.setVisibility(webView.GONE);
                    Log.d("Log.d", url);
                    verifier = uri.getQueryParameter("oauth_verifier");
                    Toast.makeText(getApplicationContext(), verifier, Toast.LENGTH_SHORT).show();
                    getAccessToken();
                }
                return false;
            }
        });
        webView.loadUrl(url);
    }

    private void getAccessToken() {
        new AsyncTask<Void, Void, OAuth1AccessToken>() {
            protected OAuth1AccessToken doInBackground(Void... params) {
                try {
                    accessToken = service.getAccessToken(requestToken, verifier);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return accessToken;
            }

            @Override
            protected void onPostExecute(OAuth1AccessToken result) {
                Toast.makeText(getApplicationContext(), "Token = " + result.getToken() + "Secret = " + result.getTokenSecret(), Toast.LENGTH_LONG).show();
            }
        }.execute();
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}