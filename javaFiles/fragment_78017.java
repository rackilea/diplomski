TextView tv=(TextView) main3Activity.findViewById(R.id.firealert);


SmsReceiver.bindListener(new SmsListener() {
                @Override
                public void messageReceived(String messageText) {
                    Log.d("Text",messageText);
                     tv.setText(messageText);
                }
            });