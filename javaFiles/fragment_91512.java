import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Second_Activity extends Activity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        String customHtml = getIntent()..getStringExtra("header");;
        webView.loadData(customHtml, "text/html", "UTF-8");

    }

}