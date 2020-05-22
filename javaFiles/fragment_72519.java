private final IMqttActionListener mConnectionCallback = new IMqttActionListener() {
    @Override
    public void onSuccess(IMqttToken asyncActionToken) {
        Log.d(LOG_TAG, "onSuccess " + asyncActionToken);
        // do nothing, this case is handled in mCallback.connectComplete method
    }

    @Override
    public void onFailure(IMqttToken asyncActionToken, Throwable ex) {
        Log.d(LOG_TAG, "onFailure " + asyncActionToken, ex);
        // initial connect has failed
    }
};

mClient = new MqttAsyncClient(mBrokerUri, mClientName, new MemoryPersistence());
mClient.setCallback(mCallback);
mClient.connect(connectOptions, null, mConnectionCallback);