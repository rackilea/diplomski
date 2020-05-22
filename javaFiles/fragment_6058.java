@Override
public void update(DataTuple data) {
    GLOBAL_APPLICATION_THREAD.execute( () -> { // Create lamba function
        int num = data.getInteger(0);
        num++;
        System.out.println("Sending " + num + ", depth: " + Thread.currentThread().getStackTrace().length);
        if (num < 1000)
            sender.signal(new DataTuple(num));
        }    
    });
}