private class WebAppInterface {
    Context mContext;
    WebAppInterface(Context c) {
        mContext = c;
    }
    @JavascriptInterface
    public void clickBtnActTwo() {
        //...
        Intent myIntent = new Intent(mContext, AdsActivity.class);
        startActivity(myIntent);
    }