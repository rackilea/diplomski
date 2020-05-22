public synchronized void callD(C cObj){
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }       
    cObj.callC1();
    cObj.notify();
}