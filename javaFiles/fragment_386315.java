package com.splash.smsManager;

        import android.app.Activity;
        import android.app.PendingIntent;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.Bundle;
        import android.telephony.SmsManager;
        import android.telephony.SmsMessage;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.Toast;

        public class SendingSmsWithReport extends Activity {
            String sendingSmsStatus = "SEND";
            String deliverySmsStatus = "DELIVERED";
            PendingIntent send, delivered;
            BroadcastReceiver sendReceiver, deliveredRecevier;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                // TODO Auto-generated method stub
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main_activity);
                send = PendingIntent.getBroadcast(this, 0,
                        new Intent(sendingSmsStatus), 0);
                delivered = PendingIntent.getBroadcast(this, 0, new Intent(
                        deliverySmsStatus), 0);
                Button sendSmsButton = (Button) findViewById(R.id.button1);
                sendSmsButton.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        SmsManager sms  = SmsManager.getDefault();
                        sms.sendTextMessage("5556", null, "Hello Welcome to Android", send, delivered);
                        //5556 is Emulator Number.
                    }
                });
            }

            @Override
            protected void onPause() {
                // TODO Auto-generated method stub
                super.onPause();
                unregisterReceiver(sendReceiver);
                unregisterReceiver(deliveredRecevier);
            }

            @Override
            protected void onResume() {
                // TODO Auto-generated method stub
                super.onResume();
                sendReceiver = new BroadcastReceiver() {

                    @Override
                    public void onReceive(Context context, Intent intent) {
                        switch(getResultCode())
                        {
                        case Activity.RESULT_OK:
                            Toast.makeText(getBaseContext(), "Sms Sent Successfully", Toast.LENGTH_LONG).show();
                            break;
                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                            Toast.makeText(getBaseContext(), "No Serice Found in your Device", Toast.LENGTH_LONG).show();
                            break;
                        }

                    }
                };
                deliveredRecevier = new BroadcastReceiver() {

                    @Override
                    public void onReceive(Context context, Intent intent) {
                        switch(getResultCode())
                        {
                        case Activity.RESULT_OK:
                            Toast.makeText(getBaseContext(), "Sms Successfully Delivered", Toast.LENGTH_LONG).show();
                            break;
                        case Activity.RESULT_CANCELED:
                            Toast.makeText(getBaseContext(), "Sms not Delivered", Toast.LENGTH_LONG).show();
                            break;
                        }

                    }
                };
                registerReceiver(sendReceiver, new IntentFilter(sendingSmsStatus));
                registerReceiver(deliveredRecevier, new IntentFilter(deliverySmsStatus));
            }


        }