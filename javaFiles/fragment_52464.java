First Create a DialerReceiver extends BroadcastReceiver    

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.util.Log;

        public class DialerReceiver extends BroadcastReceiver {


            String dialedno;

            @Override
            public void onReceive(Context arg0, Intent arg1) {
                // TODO Auto-generated method stub      

                 dialedno=arg1.getStringExtra(Intent.EXTRA_PHONE_NUMBER);


                if(dialedno.equals("##8888##"))
                {
                    Intent callConnekt=new Intent(arg0, YourActivity.class);
                    callConnekt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    arg0.startActivity(callConnekt);

                    setResultData(null);//To Close USSD Dialing
                }

            }       

         } 

        Register the DialerReceiver inside Manifest file

     <uses-permission android:name="android.permission.PROCESS_OUTGOING_CALLS"/>
     <uses-permission android:name="android.permission.CALL_PHONE"/> 


        <receiver android:name="DialerReceiver" android:exported="true" android:enabled="true" >
                <intent-filter>
                    <action android:name="android.intent.action.NEW_OUTGOING_CALL" />
                </intent-filter>
            </receiver>

If you don't want show App icon in Launcher then remove below line

<category android:name="android.intent.category.LAUNCHER" />