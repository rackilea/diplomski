import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


public class SO28161874 {
    // Makes sure the same set of strings is generated between different runs
    private static Random r = new Random();

    public static void main(String args[]) {
        final int rep = 5;

        // String r1 = "^[^@]+@[^@]+@[^@]+@[^@]+@[^@]+@$";
        String r1 = genUnroll(rep);
        // String r2 = "^(?:[^@]+@){5}$";
        String r2 = genQuantifier(rep);

        List<String> strs = new ArrayList<String>();
        // strs.addAll(generateRandomString(500, 40000, 0.002, false));
        // strs.addAll(generateRandomString(500, 40000, 0.01, false));
        // strs.addAll(generateRandomString(500, 40000, 0.01, true));
        // strs.addAll(generateRandomString(500, 20000, 0, false));
        // strs.addAll(generateRandomString(500, 40000, 0.002, true));
        strs.addAll(generateNearMatchingString(500, 40000, rep));

        /*
        // Assertion for generateNearMatchingString
        for (String s: strs) {
            assert(s.matches(r1.replaceAll("[+]", "*")));
        }
        */

        System.out.println("Test string generated");

        System.out.println(r1);
        System.out.println(test(Pattern.compile(r1), strs));

        System.out.println(r2);
        System.out.println(test(Pattern.compile(r2), strs));
    }

    private static String genUnroll(int rep) {
        StringBuilder out = new StringBuilder("^");

        for (int i = 0; i < rep; i++) {
            out.append("[^@]+@");
        }

        out.append("$");
        return out.toString();
    }

    private static String genQuantifier(int rep) {
        return "^(?:[^@]+@){" + rep + "}$";
    }

    /*
     * count -- number of strings
     * maxLength -- maximum length of the strings
     * chance -- chance that @ will appear in the string, from 0 to 1
     * end -- the string appended with @
     */
    private static List<String> generateRandomString(int count, int maxLength, double chance, boolean end) {
        List<String> out = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int length = r.nextInt(maxLength);
            for (int j = 0; j < length; j++) {
                if (r.nextDouble() < chance) {
                    sb.append('@');
                } else {
                    char c = (char) (r.nextInt(96) + 32);
                    if (c != '@') {
                        sb.append(c);
                    } else {
                        j--;
                    }
                }
            }

            if (end) {
                sb.append('@');
            }

            out.add(sb.toString());

        }

        return out;
    }

    /*
     * count -- number of strings
     * maxLength -- maximum length of the strings
     * rep -- number of repetitions of @
     */
    private static List<String> generateNearMatchingString(int count, int maxLength, int rep) {
        List<String> out = new ArrayList<String>();

        int pos[] = new int[rep - 1]; // Last @ is at the end

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int length = r.nextInt(maxLength);

            for (int j = 0; j < pos.length; j++) {
                pos[j] = r.nextInt(length);
            }
            Arrays.sort(pos);

            int p = 0;

            for (int j = 0; j < length - 1; j++) {
                if (p < pos.length && pos[p] == j) {
                    sb.append('@');
                    p++;
                } else {
                    char c = (char) (r.nextInt(95) + 0x20);
                    if (c != '@') {
                        sb.append(c);
                    } else {
                        j--;
                    }
                }
            }

            sb.append('@');

            out.add(sb.toString());

        }

        return out;
    }

    private static long test(Pattern re, List<String> strs) {
        int matches = 0;

        // 500 rounds warm-up
        for (int i = 0; i < 500; i++) {
            for (String s : strs)
              if (re.matcher(s).matches());
        }

        long accumulated = 0;

        long before = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            matches = 0;
            for (String s : strs)
              if (re.matcher(s).matches())
                matches++;
        }

        accumulated += System.currentTimeMillis() - before;

        System.out.println("Found " + matches + " matches");

        return accumulated;
    }
}