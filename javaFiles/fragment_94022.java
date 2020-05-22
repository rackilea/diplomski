import static java.lang.System.*;
import java.util.*;

public class Uni {
    public static boolean isContain(int[] src, int end, int value) {
        int start;
        for (start = 0; start < end; start++) {
            if (src[start] == value) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            out.println("Please type a number");
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                out.print(a[i] + " ");
            } else {
                if (!isContain(a, i, a[i])) {
                    out.print(a[i] + " ");
                }
            }
        }
    }
}