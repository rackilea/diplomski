WebView webView=(WebView)findViewById(R.id.ww);

     // **** use width="100%" and height="100%" to fill the webview by iFrame ******
     String playVideo= "<html><body><iframe type=\"text/html\" width=\"100%\" height=\"100%\"src=\"http:www.skyembed.com/skysports1.php\" frameborder=\"0\"></body></html>";

     webView.loadData(playVideo, "text/html", "utf-8");