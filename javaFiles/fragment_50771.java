Handler mHandlerPhone = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_USB_NAME:
                    String aResponse = (String) msg.obj;
                    Log.d(TAG, "aTTCHEDdEVICE Name handler :: " + aResponse);
                   break;
                default:

            }
        }