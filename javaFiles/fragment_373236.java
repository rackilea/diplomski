webView.setWebViewClient(new WebViewClient()
{
 public boolean shouldOverrideUrlLoading(WebView view, String url)
 {
  // YouTube video link
  if (url.startsWith("vnd.youtube:"))
  {
   int n = url.indexOf("?");
   if (n > 0)
   {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("http://www.youtube.com/v/%s", url.substring("vnd.youtube:".length(),n)));
   }
   return (true);
  }

  return (false);
 }
});