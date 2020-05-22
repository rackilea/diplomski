public class MyService extends Service implements GuiServiceBridgeItf {

....

private RunnerThread runner = null;
private CheckAliveThread checkalive = null;

private MyApplication mMyApp = null;

public void onCreate() {
    super.onCreate();

    mMyApp  = (MyApplication)getApplicationContext();
}


public int onStartCommand(Intent intent, int flags, int startId) {

    GuiServiceBridgeItf gui2ServiceTalker = this;

    checkalive = new CheckAliveThread();
    checkalive.init(mMyApp);
    checkalive.start();


    runner = new RunnerThread(this.getApplicationContext(), gui2ServiceTalker);
    runner.start();

    ...

    return START_STICKY;
}

public void onDestroy() {   
    super.onDestroy();

    ...

    runner.doDestroy();     
    runner = null;  

    checkalive.doDestroy();
    checkalive = null;

    stopSelf();
}



private boolean isInstanceActive(){
    if(mMyApp.gsb == null){
        return false;
    }

    return true;
}


public void imHere() {}

public void onEventReceived(String str) {
    if(isInstanceActive()){
        mMyApp.gsb.onEventReceived(str);
    }
}

...

}