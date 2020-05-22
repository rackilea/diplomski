import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String p = reader.readLine();
        System.out.println(s);
        System.out.println(p);      
        System.out.println(reader.ready());
    }
}