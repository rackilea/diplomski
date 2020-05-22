class MyObject {
    class Transport {
        @JavascriptInterface
        public int getField() { ... }
    }

    @JavascriptInterface
    public Object getTransport() { return new Transport(); }
}

webView.addJavascriptInterface(new MyObject(), "myObject");