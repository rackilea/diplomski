@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case Constants.MESSAGE_STATE_CHANGE:
                switch (msg.arg1) {
                    case BTHandler.STATE_CONNECTED:
                        setContentView(R.layout.activity_connected);
                        Toast.makeText(getApplicationContext(), R.string.title_connected_to, Toast.LENGTH_SHORT).show();
                        Log.v("Log", "Connected");
                        textView = (TextView)findViewById(R.id.textView);
                        break;
                    case BTHandler.STATE_NONE:
                        Toast.makeText(getApplicationContext(), R.string.title_not_connected, Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case Constants.VOLTAGE_STATUS:
                if(msg.obj != null && textView != null){
                    textView.setText((String)msg.obj)
                }
                break;
        }
    }
};