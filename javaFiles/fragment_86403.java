public class MyPlugin extends CordovaPlugin{
    public static MyPlugin instance = null;
    static CordovaWebView cordovaWebView;
    static CordovaInterface cordovaInterface;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        instance = this;
        cordovaWebView = webView;
        cordovaInterface = cordova;
    }

    @Override
    public void onDestroy() {
        instance = null;
    }
}