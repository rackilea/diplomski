public class MyTimer(){
    private Timer t;
    public MyTimer(Timer t){
        this.t = t;
    }

    public synchronized Timer getTimer(){
        return t;
    }

    public synchronized void setTimer(Timer t){
        this.t = t;
    }
}