public class Worker extends Thread {
    public Handler handler;
@Override
public run() {
    Looper.prepare();
//initialization will take a little time you if you want to send message check if handler  != null
    handler = new Handler() {
        public void handleMessage(Message msg) {
            Log.d("Worker.run()", "Got message saying " + msg.what);
        }
    };

    Looper.loop();
}

public void sendMessage(Message m)
{ 
    while(handler == null);
    handler.sendMessages(m); 
}