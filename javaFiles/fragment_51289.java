import java.io.FileReader;
import java.util.Arrays;

public class Foo {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("/tmp/a");
        int[] freq = new int[200];
        int c;
        while ((c = fr.read()) != -1) {
            freq[c] = freq[c] + 1;
        }
        System.out.println(Arrays.toString(freq));
    }
}