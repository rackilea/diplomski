package main;
import java.io.BufferedWriter;
import java.io.IOException;
public class Writer implements AutoCloseable {
    private BufferedWriter bw;
    public Writer(BufferedWriter bw) {
        this.bw = bw;
    }
    public void write(String line) {
        System.out.println("Writer write() entry. line: " + line);
        try {
            this.bw.write(line);
            this.bw.newLine();
            this.bw.flush();
        }
        catch(Exception error) {
            error.printStackTrace();
        }
        System.out.println("Writer write() exit.");
    }
    public void close() throws IOException {
        this.bw.close();
    }
}