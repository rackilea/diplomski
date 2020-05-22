private synchronized void initIoThreadClient()
  {
    final Object awContents = ReflectionUtils.extractProperty(this, new String[]
      {
        "mProvider",
        "mAwContents"
      });

    final String ioThreadClientProperty = "mIoThreadClient";
    final Object originalClient = ReflectionUtils.extractProperty(
      awContents,
      new String[]
      {
        ioThreadClientProperty
      });

    // avoid injecting twice (already injected Proxy instance has another class name)
    if (!originalClient.getClass().getSimpleName().startsWith("$Proxy"))
    {
      Object proxyClient = Proxy.newProxyInstance(
        originalClient.getClass().getClassLoader(),
        originalClient.getClass().getInterfaces(),
        new IoThreadClientInvocationHandler(originalClient));

      // inject proxy instead of original client
      boolean injected = ReflectionUtils.injectProperty(awContents, ioThreadClientProperty, proxyClient);
      if (injected)
      {
        Integer mNativeAwContents = (Integer) ReflectionUtils.extractProperty(awContents, "mNativeAwContents");
        Object mWebContentsDelegate = ReflectionUtils.extractProperty(awContents, "mWebContentsDelegate");
        Object mContentsClientBridge = ReflectionUtils.extractProperty(awContents, "mContentsClientBridge");
        Object mInterceptNavigationDelegate = ReflectionUtils.extractProperty(awContents, "mInterceptNavigationDelegate");

        boolean invoked = ReflectionUtils.invokeMethod(awContents, "nativeSetJavaPeers", new Object[]
          {
            mNativeAwContents, awContents, mWebContentsDelegate,
            mContentsClientBridge, proxyClient, mInterceptNavigationDelegate
          });
        if (!invoked)
        {
          e("Failed to inject IoThreadClient proxy");
        }
      }
    }