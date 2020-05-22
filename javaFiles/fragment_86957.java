package sample.threadexecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        ExecutorService service= Executors.newSingleThreadExecutor();
        service.submit(new BlockingThread());
        try {
            service.shutdown();
            if(service.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println(df.format(new Date())  + " execution completed");
            }else{
                System.out.println(df.format(new Date())  + " execution timeout");
            }
        } catch (InterruptedException e) {
            System.out.println(df.format(new Date())  + " monitoring interrupted");
        }

    }
}