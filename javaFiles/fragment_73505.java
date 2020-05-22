import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 */
public class ThreadTest {
    final static int N = 1000;

    static Runnable countDown(Writer writer){
        return ()->{
            for(int i = 0; i<N; i++){
                try{
                    writer.write(String.format("%d\t", i));
                } catch(Exception exc){

                }
            }

            try {
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args){
        try(
            Writer writer = Files.newBufferedWriter(Paths.get("test.txt"), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        ){
            Thread a = new Thread(countDown(writer));
            Thread b = new Thread(countDown(writer));
            a.start();
            b.start();
            a.join();
            b.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}