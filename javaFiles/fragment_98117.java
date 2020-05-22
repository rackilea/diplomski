public class MyRunner implements Runnable(){
    MutableBoolean stop = false;
    public void run(){...}
    public void stop(){
        stop = true;
    }
}