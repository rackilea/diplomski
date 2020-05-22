// Do it only once.

HandlerThread myHandlerThread = new HandlerThread("my-handler-thread");
myHandlerThread.start();

Handler myHandler = new Handler(myHandlerThread.getLooper(), new Handler.Callback() {
    @Override
    public boolean handleMessage(Message msg) {
        someHeavyProcessing((byte[]) msg.obj, msg.arg1);
        return true;
    }
});

// In audio recorder thread.
// Mind the handler reference.

while (!break_condition) {
    int num_read = recorder.read(buffer, 0, buffer.length);
    Message message = myHandler.obtainMessage();
    message.obj = buffer;
    message.arg1 = num_read;
    message.sendToTarget();
}