import java.util.*;

public class Q2_RecursivePalidrome {
    public static void main(String[] args) {
        String test = "racecar";
        System.out.println(isPalidrome(test.toCharArray(), 0, test.length() - 1));
    }

    static boolean isPalidrome(char[] test, int l, int r) {
        if (l < r) {
            if (test[l] == test[r]) {
                return (isPalidrome(test, l + 1, r - 1));
            }
            else {
                return false;
            }
        }

        return true;
    }
}