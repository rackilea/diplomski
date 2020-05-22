public class MyWorkerThread extends IntentService
{

    public MyWorkerThread()
    {
        super("SMSEngine");
        Log.d("MyWorkerThread : ", "\nCreated...");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        // Your background code goes here..
    }
}