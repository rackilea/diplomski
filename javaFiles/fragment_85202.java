class Main extends Application{
    static volatile boolean done = false;
    static Thread timeCheckThread;
    static void applicationIsExiting(){
        done = true;
        timeCheckThread.interrupt();
    }
}