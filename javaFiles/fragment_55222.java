public class JavaScriptInterface
{
    @JavascriptInterface
    public void test(String response)
    {
        MyToast.showMessage(QWWebView.this.getContext(),response);
    }
}