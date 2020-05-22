public void callMapViewer(String ip) {
    ScriptInjector.fromUrl("http//"+ip+"/mapviewer/fsmc/jslib/oraclemaps.js‌​").setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {
        @Override
        public void onFailure(Exception e) {

        }

        @Override
        public void onSuccess(Void aVoid) {
            callJSNI();
        }
    });
}

public native void callJSNI() /*-{
    $wnd.fonctionJS();
}-*/;