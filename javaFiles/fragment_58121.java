import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;

public class systemouttest {

    public static void main(String[] args) throws Exception {

        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
           System.out.println( i );
        }
        long printlntime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append( i + "\n" );
        }
        System.out.print(sb.toString());
        long stringbuildertime = System.currentTimeMillis();

        OutputStream out = new BufferedOutputStream ( System.out );
        for (int i = 0; i < 100000; i++) {
            out.write((i + "\n").getBytes());
        }
        out.flush();
        long bufferedoutputtime = System.currentTimeMillis();

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 100000; i++) {
            log.write(i + "\n");
        }
        log.flush();
        long bufferedwritertime = System.currentTimeMillis();

        System.out.println( "System.out.println: " + (printlntime - starttime) );
        System.out.println( "StringBuilder: " + (stringbuildertime - printlntime) );
        System.out.println( "BufferedoutputStream: " + (bufferedoutputtime - stringbuildertime) );
        System.out.println( "BufferedWriter: " + (bufferedwritertime - bufferedoutputtime) );
    }

}