import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = new WebView(getApplicationContext());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(final WebView view, String url) {
                webView.loadUrl("javascript: void AndroidHook.showToast(document.getElementsByTagName('body')[0].innerHTML);");
            }
        });

        webView.addJavascriptInterface(new JSInterface(), "AndroidHook");
        webView.loadUrl("http://example.com");
    }

    public class JSInterface {
        @JavascriptInterface
        public void showToast(final String html) {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Reached JS: " + html, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}