webview.webViewClient = object : WebViewClient() {
    override fun shouldOverrideUrlLoading(
        view: WebView, // <- potential to throw NPE before executing the function block!
        request: WebResourceRequest // <- as well!
    ): Boolean {
        return super.shouldOverrideUrlLoading(view, request)
    }
}