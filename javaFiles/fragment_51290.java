import org.apache.commons.lang3.StringEscapeUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Foo {

    public static void main(String[] args) throws Exception {
        write(read());
    }

    static int[] read() throws IOException {
        FileReader fr = new FileReader("/tmp/a");
        int[] freq = new int[200];
        int c;
        while ((c = fr.read()) != -1) {
            freq[c] = freq[c] + 1;
        }
        return freq;
    }

    static void write(int[] freq) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter("/tmp/b"))) {
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] != 0) {
                    char c = (char) i;
                    String s = StringEscapeUtils.escapeJava("" + c);
                    pw.println(s + " " + freq[i]);
                }
            }
        }
    }
}