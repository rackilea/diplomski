class MyService extends IntentService {
    public MyService() { 
        super(MyService.class.getSimpleName());
    }

    @Override
    public void onHandleIntent(Intent intent) {
        // your code goes here
    }
}