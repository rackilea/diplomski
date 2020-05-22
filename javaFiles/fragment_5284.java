import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BalancingBrackets {

    private static Map<Integer, Set<String>> dp = new HashMap<>();

    public static void main(String[] args) {
        Set<String> result = compute(4);

        boolean isFirst = true;
        for (String s : result) {
            if (isFirst) {
                isFirst = false;
                System.out.print(s);
            } else {
                System.out.print(", " + s);
            }
        }
    }

    private static Set<String> compute(Integer n) {
        // Return the cached result if available
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        Set<String> set = new HashSet<>();

        if (n == 0) {
            // This is the base case with n = 0, which consists only of the
            // empty string
            set.add("");
        } else if (n > 0) {
            // For generating patterns in case 1
            for (String s : compute(n - 1)) {
                set.add("(" + s + ")");
            }

            // For generating patterns in case 2
            for (int i = 1; i < n; i++) {
                Set<String> leftPatterns = compute(i);
                Set<String> rightPatterns = compute(n - i);

                for (String l : leftPatterns) {
                    for (String r : rightPatterns) {
                        set.add(l + r);
                    }
                }
            }
        } else {
            // Input cannot be negative
            throw new IllegalArgumentException("Input cannot be negative.");
        }

        // Cache the solution to save time for computing large size problems
        dp.put(n, set);

        return set;
    }

}