public void run() {
    while(true) { 
        synchronized(foo) {
            while(!invokeMyFunction) {
                foo.wait();
            }
        }
        MyFunction();
        invokeMyFunction = false;
    }
}