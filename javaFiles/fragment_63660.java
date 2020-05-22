public void run() {
        BluetoothSocket rfcSocket = mSPPCtrl.rfcConnect();
        if (rfcSocket.isConnected()) {
            mtvStatus.post(new Runnable() {
                @Override
                public void run() {
                    mtvStatus.setText("RFC-SOCKET CONNECTED");
                }
            });
        } else {
            mtvStatus.post(new Runnable() {
                @Override
                public void run() {
                    mtvStatus.setText("RFC-SOCKET NOT CONNECTED");
                }
            });
            return;
        }
    // the rest of your logic
    }