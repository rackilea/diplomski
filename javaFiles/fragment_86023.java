import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) throws IOException {
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);
        int kiek = 0;
        while (scanner.hasNext()) {
            scanner.next();
            kiek++;
        }
        Scanner scanner2 = new Scanner(file);
        String[] atrinkti = new String[kiek];
        String word = "";
        for (int i = 0; i < kiek; i++) {
            word = scanner2.next();
            if (word.length() % 2 == 0) {
                atrinkti[i] = word;
                System.out.println(atrinkti[i]);
            }
        }
    }
}