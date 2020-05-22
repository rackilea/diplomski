private webViewContentHeight;
BKWebView wv;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    wv = (BKWebView) findViewById(R.id.yourwebview);
    wv.setYourActivity(this);
    ...
}

public void callBackWebView(int contentHeight) {
    webViewContentHeight = contentHeight;
}


...
Button btn = (Button) this.getActivity().findViewById(R.id.btnCLick);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d("Get my custom webView content height", " " + webViewContentHeight); 
    }
});
...