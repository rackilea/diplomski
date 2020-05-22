@Override
public int onStartCommand(Intent intent, int flags, int startId) {

    ArrayList<String> numberlist=new ArrayList<String>();

    for(int i=0;i<numberlist.size();i++) {

        sendMsg(numberlist.get(i));
    }

    return super.onStartCommand(intent, flags, startId);
}

public void sendMsg(final String num){
    String SENT = "SMS_SENT";
    final SmsManager sms = SmsManager.getDefault();
    final PendingIntent sentPI = PendingIntent.getBroadcast(MyService.this, 0,new Intent(SENT), 0);
    Handler h = new Handler();
    h.postDelayed(new Runnable() {
        @Override
        public void run() {
            sms.sendTextMessage(num, null, "Hi MyApp SMS", sentPI, null);
        }
    }, 2000);
}