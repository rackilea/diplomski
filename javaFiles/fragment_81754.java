myWebView.setWebChromeClient(new WebChromeClient(){

        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

           if(newProgress <100){
            prDialog.setMessage("Please wait ...");
            prDialog.show();
        }

          else if (newProgress ==100){
               if(prDialog!=null && prDialog.isShowing()){
                  prDialog.dismiss();
        }
       }
    }