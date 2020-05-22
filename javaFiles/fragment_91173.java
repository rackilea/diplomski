package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Reader implements Runnable, AutoCloseable {
    private BufferedReader br;
    private Thread thread;
    private Queue<String> output = new ConcurrentLinkedQueue<>();
    private AtomicBoolean stop = new AtomicBoolean();

    public Reader(BufferedReader br) {
        this.br = br;
        this.thread = new Thread(this);
    }
    public void run() {
        System.out.println("Reader run() entry");
        while(!stop.get()) {
            try {
                // Why not just avoid the ready() call and block
                // on readLine()? We want the Main thread to be able
                // to stop the Reader thread at any time. Hence the
                // Reader thread needs to periodically check to see
                // if it has been requested to stop, and moreover
                // the Reader thread cannot block.
                while (br.ready()) {
                    output.add(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
                stop.set(true);
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reader run() exit");
    }
    public String getOutput() {
        return output.poll();
    }
    public void startListening() {
        System.out.println("Reader startListening() entry"); 
        this.thread.start();
    }
    public void close() throws IOException {
        // Note that the close() method is called by the Main thread
        // and merely sets a flag. This flag will eventually be read
        // by the Reader thread which will then close the
        // BufferedReader.
        this.stop.set(true);
    }
}