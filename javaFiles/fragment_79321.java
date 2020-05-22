package com.vvhvb.hesselfeenstra.vvheerenveenseboys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView view;
SwipeRefreshLayout mySwipeRefreshLayout;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeContainer);
    String url ="http://heerenveenseboys.nl/";
    view=(WebView) this.findViewById(R.id.webView);
    view.getSettings().setJavaScriptEnabled(true);
    view.getSettings().setBuiltInZoomControls(true);
    view.getSettings().setDisplayZoomControls(false);
    view.setWebViewClient(new WebViewClient());
    view.loadUrl(url);

    mySwipeRefreshLayout.setOnRefreshListener(
    new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        view.reload();
    }
    }
    );

}

}