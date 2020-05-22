private void ensureProviderCreated() {
    checkThread();
    if (mProvider == null) {
        // As this can get called during the base class constructor chain, pass the minimum
        // number of dependencies here; the rest are deferred to init().
        mProvider = getFactory().createWebView(this, new PrivateAccess());
    }
}