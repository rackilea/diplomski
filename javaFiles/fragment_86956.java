package sample.threadexecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockingThread implements Runnable{

    public boolean succsess = false;
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println(df.format(new Date())  + " start");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            System.out.println(df.format(new Date())  + " interrupted");
            succsess = false;
            return;
        }
        System.out.println(df.format(new Date())  + " end");
        succsess = true;
    }
}