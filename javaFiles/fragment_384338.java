private void sendSMS(String phoneNumber, String message) {

        SmsManager manager = SmsManager.getDefault();

        ArrayList<String> parts = manager.divideMessage(message);

        manager.sendMultipartTextMessage(phoneNumber, null, parts, null, null);

}