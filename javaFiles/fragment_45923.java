public void sendSMSMessage() {
    number = phoneno.getText().toString();
    txt = message.getText().toString();

    if (ContextCompat.checkSelfPermission(this,
            Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.SEND_SMS)) {
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
        return;
    }

    sendMessage();

}

public void sendMessage() {
   SmsManager smsManager = SmsManager.getDefault();
    smsManager.sendTextMessage(number, null, txt, null, null);
    Toast.makeText(getApplicationContext(), "SMS sent.",
            Toast.LENGTH_LONG).show();
}