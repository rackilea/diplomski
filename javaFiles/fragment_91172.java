package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main {
    public static boolean isProcessFinished(Process process) {
        try {
            process.exitValue();
        } catch (IllegalThreadStateException e) {
            return false;
        }
        return true;
    }

    public static void printAllOutput(Reader reader) {
        String line;
        while ((line = reader.getOutput()) != null) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "/usr/bin/script", "-qfc", "/usr/bin/python", "/dev/null");
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        OutputStream outputStream = process.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        BufferedWriter bw = new BufferedWriter(osw);
        try (
            Writer writer = new Writer(bw);
            Reader reader = new Reader(br);
        ) {
            reader.startListening();
            writer.write("2+2");
            writer.write("exit()");
            while(!isProcessFinished(process)) {
                // We don't block here. Maybe we're doing something
                // complicated at the same time. Maybe we're a web
                // server. Maybe...
                printAllOutput(reader);

                // Without this the java process hits 100% CPU.
                // This is because we're furiously checking if the
                // process has exited and looking for output. Java's
                // process handling API isn't so hot; consider using
                // another library?
                Thread.sleep(100);
            }

            // Yes, the process has finished, but there may still be output
            // to be read from the BufferedReader. Let's grab any dog-ends.
            printAllOutput(reader);
        }
    }
}