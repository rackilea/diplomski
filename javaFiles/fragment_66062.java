import java.util.Scanner;

public class Test {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while ((t--) > 0) {
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(ms(s1, s2));
    }
}

public static String ms(String s1, String s2) {
    StringBuffer sb = new StringBuffer();
    int i, j;
    for (i = 0, j = 0; i < s1.length() && j < s2.length();) {
        if (s1.charAt(i) > s2.charAt(j)) {
            sb.append(s2.charAt(j));
            if (j == s2.length())
                break;
            else
                j++;
        } else {
            sb.append(s1.charAt(i));
            if (i == s1.length())
                break;
            else
                i++;
        }
    }

    if (j == s2.length()) {
        for (; i < s1.length(); i++)
            sb.append(s1.charAt(i));

        return sb.toString();
    }

    else {
        for (; j < s2.length(); j++)
            sb.append(s2.charAt(j));

        return sb.toString();
    }
}
}