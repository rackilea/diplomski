/**
 * The Handler that gets information back from the BTManager
 */
private final Handler mHandler = new Handler() {
    @Override public void handleMessage(android.os.Message msg) {
        switch (msg.what) {
            case Constants.MESSAGE_STATE_CHANGE:
                switch (msg.arg1) {
                    case BluetoothManager.STATE_CONNECTED:
                        //  TODO
                        break;
                    // todo .../
                }
                break;
            case Constants.MESSAGE_READ:
                byte[] readBuf = (byte[]) msg.obj;
                // construct a string from the valid bytes in
                // the buffer
                String readMessage =
                        new String(readBuf, 0, msg.arg1);
                // TODO display your string message
                break;
                // todo .../               
        }
    }
};