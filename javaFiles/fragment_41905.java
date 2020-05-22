package com.example.nilesh.testapp;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    public String url;
    private ProgressBar mProgressBar;
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String url = getIntent().getStringExtra("URL");
        // Request window feature action bar
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        myWebView = findViewById(R.id.webview);
        myWebView.loadUrl(url);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.getSettings().setAllowFileAccess(true);

        // Get the widgets reference from XML layout
        mProgressBar = findViewById(R.id.pb);
        SwipeRefreshLayout mySwipeRefreshLayout=new SwipeRefreshLayout(this);
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        //code to check network availability
        if(!isNetworkAvailable()){
            //Create an alertdialog
            AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(Webview.this);
            Checkbuilder.setIcon(R.drawable.error);
            Checkbuilder.setTitle("Error!");
            Checkbuilder.setMessage("Check Your Internet Connection.");
            //Builder Retry Button

            Checkbuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //Restart The Activity
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            Checkbuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }) ;

            AlertDialog alert=Checkbuilder.create();
            alert.show();

        }
        //If internet is available load the url
        else {
            // Request to render the web page
            if (savedInstanceState == null) {
                myWebView.loadUrl(url);
            }
        }

        Configuration config = getResources().getConfiguration();

        final SwipeRefreshLayout finalMySwipeRefreshLayout1 = mySwipeRefreshLayout;
        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);
                // Visible the progressbar
                mProgressBar.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                finalMySwipeRefreshLayout1.setRefreshing(false);
            }
        });


        //Code for handling download
        myWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request( Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "download");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);

                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"Downloading...",Snackbar.LENGTH_SHORT);
                snackbar.show();
                // Changing message text color
                snackbar.setActionTextColor(Color.YELLOW);
            }
        });

        /*
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * performs a swipe-to-refresh gesture.
         */
        final SwipeRefreshLayout finalMySwipeRefreshLayout = mySwipeRefreshLayout;
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        //Log.i(TAG, "onRefresh called from SwipeRefreshLayout");

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        myWebView.loadUrl(String.valueOf(url));
                    }
                }
        );

        myWebView.setWebChromeClient(new WebChromeClient(){

            public void onProgressChanged(WebView view, int newProgress){
                // Update the progress bar with page loading progress
                mProgressBar.setProgress(newProgress);
                if(newProgress == 100){
                    // Hide the progressbar
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });

    /*btnback.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            if (myWebView.canGoBack()) {
                myWebView.goBack();
            }
        }
    });*/

    }


    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo !=null;
    }


    public class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            // Visible the progressbar
            mProgressBar.setVisibility(View.VISIBLE);
        }

        public void onProgressChanged(WebView view, int newProgress){
            // Update the progress bar with page loading progress
            mProgressBar.setProgress(newProgress);
            if(newProgress == 100){
                // Hide the progressbar
                mProgressBar.setVisibility(View.GONE);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.stop) {
            //myWebView.stopLoading();
        } else if(id == R.id.home){
            finish();
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
            return;
        }
        // Otherwise defer to system default behavior.
        super.onBackPressed();
    }

}