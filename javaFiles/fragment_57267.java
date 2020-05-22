public class AlarmReceiver extends BroadcastReceiver {
    RequestParams params = new RequestParams();
    @Override
    public void onReceive(final Context context, Intent intent)
    {
//This is the message come from another class
String msg = bundle.getString("mess");

//check if the message is not null
        if(PatternChecker.isNotNull(msg)) {
            params.put("message",msg);
            Webservice();
        }
}

WebService method here to perform the sending data to the webservice.