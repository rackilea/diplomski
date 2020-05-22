myWebView.setWebViewClient(new WebViewClient() {
                               public void onPageFinished(WebView view, String url) {

                                   loadCount = 0;
                                   if (loadCount == 0) {
                                           myWebView.loadUrl(
                                                   "javascript:document.getElementById('user_login').value = '" + prfs.getString("Username", "Incorrect credentials") + "';" +
                                                   "javascript:document.getElementById('user_pass').value = '" + prfs.getString("Password", "Incorrect credentials") + "';" +
                                                   "javascript:document.getElementById('wp-submit').click();"

                                           );
                                           loadCount++;
                                       } else if (loadCount == 1) {
                                           myWebView.loadUrl(url);

                                       }
                                   }
                               });