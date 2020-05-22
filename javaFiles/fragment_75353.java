Intent sentInt = new Intent(SmsNotificationSending.SENT);
    sentInt.putExtra("SMS_ID", _smsRequest.getmId());
    PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, sentInt, 0);

    Intent delivInt = new Intent(SmsNotificationSending.DELIVERED);
    delivInt.putExtra("SMS_ID", _smsRequest.getmId());
    PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, delivInt, 0);