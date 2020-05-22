import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        System.out.println("started");

        try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            for (String line = console.readLine(); line != null; line = console.readLine()) {
                System.out.printf("Your sentence: %s\n", line);
            }
        }

    }
}