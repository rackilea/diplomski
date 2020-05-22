public class MyApplication extends Application{ 

    private static mYApplication mSingleton;

    public GuiServiceBridgeItf gsb = null;

 @Override
 public void onCreate() {
    super.onCreate();
    mSingleton = this;
 } 

 public mYApplication getApp(){
    return mSingleton;
 }
....
}