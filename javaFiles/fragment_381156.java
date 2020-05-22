package stackoverflow.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int arr_i = 0; arr_i < n; arr_i++){
            sb.append(in.nextInt());
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        String normal = sb.toString();
        String reversed = sb.reverse().toString();

        System.out.println("normal: " + normal);
        System.out.println("reversed: " + reversed);
    }
}