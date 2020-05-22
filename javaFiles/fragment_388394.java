package com.example.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A minimal WebView app with HTML5 geolocation capability
 *
 * @author David M. Chandler
 */
public class GeoWebViewActivity extends Activity {

    /**
     * WebViewClient subclass loads all hyperlinks in the existing WebView
     */
    public class GeoWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // When user clicks a hyperlink, load in the existing WebView
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * WebChromeClient subclass handles UI-related calls
     * Note: think chrome as in decoration, not the Chrome browser
     */
    public class GeoWebChromeClient extends WebChromeClient {
       @Override
public void onGeolocationPermissionsShowPrompt(String origin,
                                               GeolocationPermissions.Callback callback) {
    // Geolocation permissions coming from this app's Manifest will only be valid for devices with
    // API_VERSION < 23. On API 23 and above, we must check for permissions, and possibly
    // ask for them.
    String perm = Manifest.permission.ACCESS_FINE_LOCATION;
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
            ContextCompat.checkSelfPermission(MainActivity.this, perm) == PackageManager.PERMISSION_GRANTED) {
        // we're on SDK < 23 OR user has already granted permission
        callback.invoke(origin, true, false);
    } else {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, perm)) {
            // ask the user for permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {perm}, REQUEST_FINE_LOCATION);

            // we will use these when user responds
            mGeolocationOrigin = origin;
            mGeolocationCallback = callback;
        }
    }
    }


    @Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
        case REQUEST_FINE_LOCATION:
            boolean allow = false;
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // user has allowed this permission
                allow = true;
            }
            if (mGeolocationCallback != null) {
                // call back to web chrome client
                mGeolocationCallback.invoke(mGeolocationOrigin, allow, false);
            }
            break;
    }
}
    WebView mWebView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mWebView = (WebView) findViewById(R.id.webView1);
        // Brower niceties -- pinch / zoom, follow links in place
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new GeoWebViewClient());
        // Below required for geolocation
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setGeolocationEnabled(true);
        mWebView.setWebChromeClient(new GeoWebChromeClient());
        // Load google.com
        mWebView.loadUrl("http://www.google.com");
    }

    @Override
    public void onBackPressed() {
        // Pop the browser back stack or exit the activity
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}