import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
            List<Character> charIn = new ArrayList<Character>();
            String word = "";
            boolean cond = false;
            Scanner sc = new Scanner(System.in);

            while (cond == false) {
                System.out.print("Please enter a Character: ");
                String next = sc.next();
                charIn.add(next.charAt(0));
                if ("0".equals(next)) {
                    cond = true;
                }else{
                    cond = false;
                }

            }
            word = charIn.toString();
            System.out.println(word);

        }
}