public class MyWb extends Activity {
/** Called when the activity is first created. */

WebView web;
ProgressBar progressBar;

private ValueCallback<Uri> mUploadMessage;  
 private final static int FILECHOOSER_RESULTCODE=1;  

 @Override  
 protected void onActivityResult(int requestCode, int resultCode,  
                                    Intent intent) {  
  if(requestCode==FILECHOOSER_RESULTCODE)  
  {  
   if (null == mUploadMessage) return;  
            Uri result = intent == null || resultCode != RESULT_OK ? null  
                    : intent.getData();  
            mUploadMessage.onReceiveValue(result);  
            mUploadMessage = null;  
  }
  }  

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    web = (WebView) findViewById(R.id.webview01);
    progressBar = (ProgressBar) findViewById(R.id.progressBar1);

    web = new WebView(this);  
    web.getSettings().setJavaScriptEnabled(true);
    web.loadUrl("http://www.script-tutorials.com/demos/199/index.html");
    web.setWebViewClient(new myWebClient());
    web.setWebChromeClient(new WebChromeClient()  
    {  
           //The undocumented magic method override  
           //Eclipse will swear at you if you try to put @Override here  
        // For Android 3.0+
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {  

            mUploadMessage = uploadMsg;  
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
            i.addCategory(Intent.CATEGORY_OPENABLE);  
            i.setType("image/*");  
            MyWb.this.startActivityForResult(Intent.createChooser(i,"File Chooser"), FILECHOOSER_RESULTCODE);  

           }

        // For Android 3.0+
           public void openFileChooser( ValueCallback uploadMsg, String acceptType ) {
           mUploadMessage = uploadMsg;
           Intent i = new Intent(Intent.ACTION_GET_CONTENT);
           i.addCategory(Intent.CATEGORY_OPENABLE);
           i.setType("*/*");
           MyWb.this.startActivityForResult(
           Intent.createChooser(i, "File Browser"),
           FILECHOOSER_RESULTCODE);
           }

        //For Android 4.1
           public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture){
               mUploadMessage = uploadMsg;  
               Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
               i.addCategory(Intent.CATEGORY_OPENABLE);  
               i.setType("image/*");  
               MyWb.this.startActivityForResult( Intent.createChooser( i, "File Chooser" ), MyWb.FILECHOOSER_RESULTCODE );

           }

    });  


    setContentView(web);  


}

public class myWebClient extends WebViewClient
{
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        // TODO Auto-generated method stub
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub

        view.loadUrl(url);
        return true;

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub
        super.onPageFinished(view, url);

        progressBar.setVisibility(View.GONE);
    }
}

//flipscreen not loading again
@Override
public void onConfigurationChanged(Configuration newConfig){        
    super.onConfigurationChanged(newConfig);
}

// To handle "Back" key press event for WebView to go back to previous screen.
/*@Override
public boolean onKeyDown(int keyCode, KeyEvent event) 
{
    if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
        web.goBack();
        return true;
    }
    return super.onKeyDown(keyCode, event);
}*/
}