public class MyWebViewClient extends WebViewClient {
    private Context mContext;
    private ProgressDialog mDialog;

  public MyWebViewClient(Context context){
    mContext = context;
  }

  @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mDialog = ProgressDialog.show(mContext, "", "Loading...", true);
        }

    @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mDialog.dismiss();
        }

 }