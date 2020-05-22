private static synchronized WebViewFactoryProvider getFactory() {
    // For now the main purpose of this function (and the factory abstration) is to keep
    // us honest and minimize usage of WebViewClassic internals when binding the proxy.
    checkThread();
    return WebViewFactory.getProvider();
}