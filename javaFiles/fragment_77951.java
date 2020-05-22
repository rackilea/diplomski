interface Callable {
    void call(Data d);
}

class MyThread implements Runnable{
    Callable callable;

    public MyThread(Callable c){
        callable = c;
    }
    void run(){
        while(true){
             callable.call(/** pass your data */);
             //sleep 10 minutes
        }
    }
}