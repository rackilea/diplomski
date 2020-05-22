class X{
    volatile int x;
    final CountDownLatch cdl = new CountDownLatch(1);

    void methodX(){
        // do work here
        cdl.countDown();
    }

    int getX(){
        cdl.await();
        return x;
    }
}

class Y{
    void methodY(X x){
        int z = X.getX();
    }
}