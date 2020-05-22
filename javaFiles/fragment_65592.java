String html = "<html><body>Hello, World!</body></html>";
String mime = "text/html";
String encoding = "utf-8";

final WebView myWebView = (WebView)this.findViewById(R.id.myWebView);
myWebView.getSettings().setJavaScriptEnabled(true);
myWebView.loadDataWithBaseURL(null, html, mime, encoding, null);

Button printButton = (Button)findViewById(R.id.print_button);
printButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        createWebPrintJob(myWebView);
    }
});