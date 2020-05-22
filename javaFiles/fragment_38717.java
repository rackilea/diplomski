public static void getBitmapFromWebview(WebView webView, final WhenReady callback){

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {

            callback.doSomethingWithBitmap(bitmap);
        }
    }, 2000);
}