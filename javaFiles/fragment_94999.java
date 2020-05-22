import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.getInt();
        System.out.println(factorial(n));

        int factorial(int a) {                  // <=== Problem
            if (a == 0)
                return 0;
            else
                return (a * factorial(a - 1));
        }
    }
}