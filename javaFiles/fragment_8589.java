@Override
public void init(Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
    Context context = mContext;

    // Used by the chrome stack to find application paths
    JniUtil.setContext(context);

    mCallbackProxy = new CallbackProxy(context, this);
    mViewManager = new ViewManager(this);
    L10nUtils.setApplicationContext(context.getApplicationContext());
    mWebViewCore = new WebViewCore(context, this, mCallbackProxy, javaScriptInterfaces);
    mDatabase = WebViewDatabaseClassic.getInstance(context);
    mScroller = new OverScroller(context, null, 0, 0, false); //TODO Use OverScroller's flywheel
    mZoomManager = new ZoomManager(this, mCallbackProxy);

    /* The init method must follow the creation of certain member variables,
     * such as the mZoomManager.
     */
    init();
    setupPackageListener(context);
    setupProxyListener(context);
    setupTrustStorageListener(context);
    updateMultiTouchSupport(context);

    if (privateBrowsing) {
        startPrivateBrowsing();
    }

    mAutoFillData = new WebViewCore.AutoFillData();
    mEditTextScroller = new Scroller(context);
}