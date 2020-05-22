public void onCreate() {
    super.onCreate();
    EventBus.getDefault().register(this);
}

@Override
public void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
}