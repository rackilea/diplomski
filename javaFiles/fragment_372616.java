mWebView = (WebView) findViewById(R.id.webView);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT > 7) {
            settings.setPluginState(PluginState.ON);
        } else {
            settings.setPluginsEnabled(true);
        }

        String html = "";
        html += "<html><body>";
        html += "<iframe width=\"560\" height=\"315\" src=\"http://www.youtube.com/embed/MU9Srs04sFU?rel=0\" frameborder=\"0\" allowfullscreen></iframe>";
        html += "</body></html>";

mWebView.loadData(html, "text/html", null);