05-02 09:06:19.514: ERROR/AndroidRuntime(519): FATAL EXCEPTION: main
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.stacktest/com.example.stacktest.MyActivity}: java.lang.NullPointerException
    at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2663)
    at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2679)
    at android.app.ActivityThread.access$2300(ActivityThread.java:125)
    at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2033)
    at android.os.Handler.dispatchMessage(Handler.java:99)
    at android.os.Looper.loop(Looper.java:123)
    at android.app.ActivityThread.main(ActivityThread.java:4627)
    at java.lang.reflect.Method.invokeNative(Native Method)
    at java.lang.reflect.Method.invoke(Method.java:521)
    at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:868)
    at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:626)
    at dalvik.system.NativeStart.main(Native Method)
    Caused by: java.lang.NullPointerException
    at com.example.stacktest.MyActivity.onCreate(MyActivity.java:38)
    at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1047)
    at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2627)
    ... 11 more