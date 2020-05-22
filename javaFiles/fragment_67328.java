if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    webSettings.setMixedContentMode(0);
    webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
} else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
} else {
    webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
}