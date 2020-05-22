private void bindIntent() {
        Log.e(TAG, "Bind intent");

        Intent intent = new Intent(this, ServiceSpeechRecognition.class);
        startService(intent);
        bindService(intent, mConnection, 0);
    }