webview.setWebViewClient(new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dialog.dismiss();
        }
    });



   public void onClick(View v){
       switch(v.getId()){

       case R.id.refresh:
            dialog = ProgressDialog.show(Quotes.this, "", "Loading...", true);
            webview.reload();

            }
       }
  }