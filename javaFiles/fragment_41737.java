if (activityContext == null) {
            using(AndroidJavaClass activityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer")) {
                activityContext = activityClass.GetStatic<AndroidJavaObject>("currentActivity");
            }
        }

        using(AndroidJavaClass pluginClass = new AndroidJavaClass("example.com.Class")) {
            if(pluginClass != null) {
                className = pluginClass.CallStatic<AndroidJavaObject>("getInstance");
                activityContext.Call("runOnUiThread", new AndroidJavaRunnable(() => {
                    className.Call("methodName", activityContext);
                }));
            }
        }