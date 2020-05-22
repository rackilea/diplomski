while (true) {
    try {
        Bundle bundle = new Bundle();
        String line = mBufferedReader.readLine();
        Log.d("message" , line );
        bundle.putString(RemoteBluetooth.READ, line);
        Message msg=mHandler.obtainMessage(RemoteBluetooth.MESSAGE_READ,line.length(),-1,buffer);
        msg.setData(bundle);
        mHandler.sendMessage(msg);
    } catch (IOException e) {
        Log.e(TAG, "disconnected", e);
        connectionLost();
        Log.e( TAG, "Could not connect to device", e );
        close( mBufferedReader );
        close( aReader );
        break;
    }
}