package com.adySol;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

public class adySol extends Activity {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);



     String url ="file:///android_asset/mulberrybush.swf";
    // String url ="http://www.bing.com/";
 WebView wv=(WebView) findViewById(R.id.webView1);
 wv.getSettings().setJavaScriptEnabled(true);
    wv.getSettings().setPluginState(PluginState.ON);
    wv.getSettings().setAllowFileAccess(true); 
 wv.loadUrl(url);

}
}