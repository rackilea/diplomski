import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> resultList = new ArrayList<>();

    static void computeResult(char[] s, int pos, String resultString) {
        if (pos == 3) {
            resultList.add(resultString);
            return;
        }
        for (int i = 0; i < 3; ++i) {
            if (!resultString.contains(String.valueOf(s[i]))) {
                computeResult(s, pos + 1, resultString + s[i]);
            }
        }
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        sc.close();
        computeResult(s, 0, "");
        for(String str : resultList) {
            System.out.println(str);
        }
    }
}