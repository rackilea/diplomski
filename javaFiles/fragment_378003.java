import java.util.Scanner;

public class Hello2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(' ').append(sc.nextLine());
        System.out.println(sb.append('.').toString());
    }
}