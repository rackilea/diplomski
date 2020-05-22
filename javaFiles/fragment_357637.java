public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        //url = webView.getUrl(); --remove this. You already have the URL in String url parameter
        if (url.endsWith(".m3u8") || url.endsWith(".ts") || url.endsWith(".amv") || url.endsWith(".mp4"))
        {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri videoUri = Uri.parse(url);
            intent.setDataAndType( videoUri, "application/x-mpegURL" );
            intent.setPackage( "com.mxtech.videoplayer.ad" );
            startActivity( intent );
            return true; // to tell the WebView that it should not load the URL because you handled it by yourself
        }
        //webView.loadUrl(url);  remove this. You need to return true or false to tell the WebView if it should load the url, or not
        return false; //to tell WebView that you didn't handle the URL, and it should load it.
    }