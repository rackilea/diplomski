//1. Define a java class that represents your event:
public static class MessageEvent {
    /* Additional fields if needed */ 
}

//2.Post events at your origin like as below and receive them in destination (@Subscribe methods):
EventBus.getDefault().post(new MessageEvent());

//3.Prepare subscribers in destinations: Declare and annotate your subscribing method, optionally specify a thread mode:
@Subscribe(threadMode = ThreadMode.MAIN)  
public void onMessageEvent(MessageEvent event) {
    /* Do something */
};

//4.Register and unregister your subscriber in the destination, according to your component (here service class) life cycle:
@Override
public void onCreate() {
    super.onCreate();
    EventBus.getDefault().register(this);
}
@Override
public void onDestroy() {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
}