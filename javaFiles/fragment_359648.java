public class AlarmReceiver extends BroadcastReceiver 
{
    @Override
    public void onReceive(Context context, Intent intent) 
    {
        try 
        {
            Bundle bundle = intent.getExtras();
            String message = bundle.getString("alarm_message");
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        } 
        catch (Exception e) 
        {
             Toast.makeText(context, "There was an error somewhere, but we still received an alarm", Toast.LENGTH_SHORT).show();
 e.printStackTrace();
        }
   }
}