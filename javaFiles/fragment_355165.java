@Override
public void run() {
    for(int i = 0; i < 5; i++){
        ClassThread ct = new ClassThread(var);
        Thread t = new Thread(ct);
        t.start();
    }
}