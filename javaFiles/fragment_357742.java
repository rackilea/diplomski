@Override
public void onPageStarted(WebView view, String url, Bitmap favicon) {

     if(url.contains("index.php") 
      {
       findViewById(R.id.toolbar_footer).setVisibility(View.GONE);
      }
    else
     {
    findViewById(R.id.toolbar_footer).setVisibility(View.VISIBLE);
     }
}