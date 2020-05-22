MyClass mc = new MyClass();
    Thread thread = new Thread(mc);
    thread.start();
    for (int i = 0; i < 100; ++i)
    {
        MyObject obj = new MyObject();
        mc.addToQueue(obj);
    }