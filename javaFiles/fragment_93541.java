public class MyService extends Service {
    public void onDestroy() {
        super.onDestroy();

        MyApplication application = (MyApplication) getApplication();
        application.flushCache();
    }
}