import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {

        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();

        Scanner s = new Scanner(str);

        while (s.hasNext()) {

            System.out.println(s.nextInt());

        }

        System.out.println("done");

    }

}