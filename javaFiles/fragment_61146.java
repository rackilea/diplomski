// Watch for send button clicks and send text messages.
    Button sendButton = (Button) findViewById(R.id.sms_send_message);
    sendButton.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            if (TextUtils.isEmpty(recipientTextEdit.getText())) {
                Toast.makeText(SmsMessagingDemo.this, "Please enter a message recipient.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(contentTextEdit.getText())) {
                Toast.makeText(SmsMessagingDemo.this, "Please enter a message body.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            recipientTextEdit.setEnabled(false);
            contentTextEdit.setEnabled(false);

            SmsManager sms = SmsManager.getDefault();

            List<String> messages = sms.divideMessage(contentTextEdit.getText().toString());

            String recipient = recipientTextEdit.getText().toString();
            for (String message : messages) {
                sms.sendTextMessage(recipient, null, message, PendingIntent.getBroadcast(
                        SmsMessagingDemo.this, 0, new Intent(ACTION_SMS_SENT), 0), null);
            }
        }
    });