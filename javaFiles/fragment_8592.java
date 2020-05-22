static WebViewFactoryProvider getProvider() {
    synchronized (sProviderLock) {
        // For now the main purpose of this function (and the factory abstraction) is to keep
        // us honest and minimize usage of WebViewClassic internals when binding the proxy.
        if (sProviderInstance != null) return sProviderInstance;

        // For debug builds, we allow a system property to specify that we should use the
        // Chromium powered WebView. This enables us to switch between implementations
        // at runtime. For user (release) builds, don't allow this.
        if (Build.IS_DEBUGGABLE && SystemProperties.getBoolean("webview.use_chromium", false)) {
            StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
            try {
                sProviderInstance = loadChromiumProvider();
                if (DEBUG) Log.v(LOGTAG, "Loaded Chromium provider: " + sProviderInstance);
            } finally {
                StrictMode.setThreadPolicy(oldPolicy);
            }
        }

        if (sProviderInstance == null) {
            if (DEBUG) Log.v(LOGTAG, "Falling back to default provider: "
                    + DEFAULT_WEBVIEW_FACTORY);
            sProviderInstance = getFactoryByName(DEFAULT_WEBVIEW_FACTORY,
                    WebViewFactory.class.getClassLoader());
            if (sProviderInstance == null) {
                if (DEBUG) Log.v(LOGTAG, "Falling back to explicit linkage");
                sProviderInstance = new WebViewClassic.Factory();
            }
        }
        return sProviderInstance;
    }
}