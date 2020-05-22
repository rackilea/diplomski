import java.io.*;
import java.util.*;

public class ProblemTwo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a post value expression: ");
        String input = scan.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        Stack hello = new Stack(st.countTokens());

        for (int i = 0; i <= st.countTokens()+1; i++) {
            String inputToken = st.nextToken();
            if (inputToken.trim().contains("+")) {
                int sum = Integer.parseInt(hello.pop()) + Integer.parseInt(hello.pop());
                System.out.println(sum);
                hello.push(Integer.toString(sum));
            }
            else if (inputToken.trim().contains("*")){
                int product = Integer.parseInt(hello.pop()) * Integer.parseInt(hello.pop());
                hello.push(Integer.toString(product));
            }
            else {
                hello.push(inputToken);
            }
        }
        System.out.println(hello.pop());
    }
}