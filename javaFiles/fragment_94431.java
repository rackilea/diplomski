import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class ListeningToBoot extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO Auto-generated method stub
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String urphone = tm.getLine1Number();
            Log.v("Uphone","is "+urphone);
            Toast.makeText(context, "MDN:"+urphone, Toast.LENGTH_SHORT).show(); 

            SharedPreferences prefs = context.getSharedPreferences("MySimPreferences", Context.MODE_PRIVATE);
            String mobile_No=prefs.getString("MDN", "un-known");
            Log.v("from shared pref","MDN"+mobile_No);
            String imei=prefs.getString("IMEI", "un-known");
            Log.v("from shared pref","IMEI"+imei);

            if(urphone.equals(mobile_No))
            {
                Log.v("MDN is same","shoudl do nothing");
                Toast.makeText(context, "MDN no change", Toast.LENGTH_LONG).show();
            }
            else
            {
                Log.v("MDN is not same","send a message to someone");
                SharedPreferences prefs_names = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                String number_to_send=prefs_names.getString("Moblie_Number", "un-known");
                Toast.makeText(context, "MDN changed", Toast.LENGTH_LONG).show();
                String message_to_send="Your mobile number chagned:\nNew Number: "+urphone+"\nIMEI: "+imei;
                SmsManager.getDefault().sendTextMessage(number_to_send, null, message_to_send, null,null);
            }
        }           
    }

}