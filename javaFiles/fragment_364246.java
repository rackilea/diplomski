public class GPSServiceAndroidTest : MonoBehaviour {

    private AndroidJavaObject activity = null;
    private AndroidJavaObject launcher = null;

    void Start () {

        using(AndroidJavaClass activityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer")){
            activity = activityClass.GetStatic<AndroidJavaObject>("currentActivity");
        }

        using(AndroidJavaClass pluginClass = new AndroidJavaClass("com.softserve.gpstest.Launcher")){
            if(pluginClass!=null){
                launcher = pluginClass.CallStatic<AndroidJavaObject>("instance");
                launcher.Call("startTustanService", activity);
            }
        }
    }
}