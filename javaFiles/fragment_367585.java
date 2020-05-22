public void onClick(View arg0) {

    String p = "+989357835774";
    String m = "test";
    SendSMS sms = new SendSMS(this);
    sms.sms(p, m);
}


public class SendSMS {

    private Context context;

    public SendSMS(Context context) {
        this.context = context;
    }

    public void sms (String phonno , String Message){
        PendingIntent pi = PendingIntent.getActivity(context, 0,
            new Intent(context, YourActivity.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phonno, "+9891100500", Message , pi, null);  
    }
}