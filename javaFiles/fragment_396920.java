AndroidJavaClass unityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
AndroidJavaObject unityActivity = unityClass.GetStatic<AndroidJavaObject>("currentActivity");
AndroidJavaObject unityContext = unityActivity.Call<AndroidJavaObject>("getApplicationContext");

AndroidJavaClass pluginClass = new AndroidJavaClass("com.overly.mutecontrol.AndroidMuteCtrl");
//Send the Context
pluginClass.CallStatic("receiveContextInstance", unityContext);
bool isMuted = pluginClass.CallStatic<bool>("isMuted");