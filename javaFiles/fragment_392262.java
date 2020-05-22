import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Foo {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Foo.java"))) {
            System.out.println(reader.readLine());
        } 
    }
}