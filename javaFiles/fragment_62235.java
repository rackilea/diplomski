Handler h = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            SmsManager sms = SmsManager.getDefault();
            Handler h = new Handler();
Runnable r = new Runnable() {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(null, null, null, null,
                null);
    }
};
h.postDelayed(r, 1000);

    }
};