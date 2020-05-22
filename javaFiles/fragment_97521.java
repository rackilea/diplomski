public static PrintDocumentAdapter.LayoutResultCallback getLayoutResultCallback(InvocationHandler invocationHandler,
                                                                                File dexCacheDir) throws  IOException{
    return ProxyBuilder.forClass(PrintDocumentAdapter.LayoutResultCallback.class)
            .dexCache(dexCacheDir)
            .handler(invocationHandler)
            .build();
}