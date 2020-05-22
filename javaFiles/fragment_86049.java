import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ToyConc1 {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            Callable<String> op1 = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return slowlyGetHttpPage("http://www.google.com");
                }
            }; 
            Callable<String> op2 = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return slowlyGetHttpPage("http://edition.cnn.com/");
                }
            }; 
            Future<String> resF1 = exec.submit(op1);
            Future<String> resF2 = exec.submit(op2);

            for (int i = 0; i < 20; i++) {
                System.out.println("doing useful work on the main thread...");
            }
            System.out.println("The object 1 is " + limit(resF1.get(), 1000) + ", wooh!");
            System.out.println("The object 2 is " + limit(resF2.get(), 1000) + ", wooh!");
        } finally {
            exec.shutdown();
            exec.awaitTermination(60, TimeUnit.SECONDS);
        }
    }

    private static String slowlyGetHttpPage(String urlName) throws InterruptedException,
            IOException {
        Thread.sleep(2000);
        URL url = new URL(urlName);
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(in); // wrong charset maybe
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    private static String limit(String s, int length) {
        if (s == null) {
            return null;
        }
        if (s.length() <= length) {
            return s;
        }
        return s.substring(0, length) + " [and " + (s.length() - length) + " more]";
    }
}