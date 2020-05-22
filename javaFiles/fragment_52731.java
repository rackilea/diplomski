mWebView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) 
                   {
                   if(progress < 100 && Pbar.getVisibility() == ProgressBar.GONE){
                       Pbar.setVisibility(ProgressBar.VISIBLE);
                   }
                   Pbar.setProgress(progress);
                   if(progress == 100) {
                       Pbar.setVisibility(ProgressBar.GONE);
                   }
                }
            });