import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

interface Checker {
    String[] VALUES = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    boolean contains(String s);
}

class HashSetChecker implements Checker {
    private final Set<String> set = new HashSet<>(Arrays.asList(VALUES));

    @Override
    public boolean contains(String s) {
        return set.contains(s);
    }
}

class HashSetChecker2 implements Checker {
    private final Set<String> set = new HashSet<>(1000);
    {
        set.addAll(Arrays.asList(VALUES));
    }

    @Override
    public boolean contains(String s) {
        return set.contains(s);
    }
}

class HashMapChecker implements Checker {
    private final Map<String, Object> map = new HashMap<>(1000);
    {
        for (String s : VALUES)
            map.put(s, s);
    }

    @Override
    public boolean contains(String s) {
        return map.containsKey(s);
    }
}

class TreeSetChecker implements Checker {
    private final Set<String> set = new TreeSet<>(Arrays.asList(VALUES));

    @Override
    public boolean contains(String s) {
        return set.contains(s);
    }
}

class OrChecker implements Checker {
    @Override
    public boolean contains(String s) {
        return "zero".equals(s) || "one".equals(s) || "two".equals(s) || "three".equals(s)
                || "four".equals(s) || "five".equals(s) || "six".equals(s) || "seven".equals(s)
                || "eight".equals(s) || "nine".equals(s);
    }
}

class RefOrChecker extends OrChecker {
    @Override
    public boolean contains(String s) {
        return "zero" == s || "one" == s || "two" == s || "three" == s || "four" == s || "five" == s
                || "six" == s || "seven" == s || "eight" == s || "nine" == s || super.contains(s);
    }
}

class SwitchChecker implements Checker {
    @Override
    public boolean contains(String s) {
        switch (s) {
        case "zero":
        case "one":
        case "two":
        case "three":
        case "four":
        case "five":
        case "six":
        case "seven":
        case "eight":
        case "nine":
            return true;
        default:
            return false;
        }
    }
}

class EmbeddedSwitchChecker implements Checker {
    @Override
    public boolean contains(String s) {
        switch (s.length()) {
        case 3:
            switch (s) {
            case "one":
            case "two":
            case "six":
                return true;
            default:
                return false;
            }
        case 4:
            switch (s) {
            case "zero":
            case "four":
            case "five":
            case "nine":
                return true;
            default:
                return false;
            }
        case 5:
            switch (s) {
            case "three":
            case "seven":
            case "eight":
                return true;
            default:
                return false;
            }
        default:
            return false;
        }
    }
}

class CharSwitchChecker implements Checker {
    @Override
    public boolean contains(String s) {
        final int length = s.length();
        if (length < 3 || length > 5)
            return false;

        switch (s.charAt(0)) {
        case 'z':
            return "zero".equals(s);
        case 'o':
            return "one".equals(s);
        case 't':
            return s.charAt(1) == 'w' ? "two".equals(s) : "three".equals(s);
        case 'f':
            return s.charAt(1) == 'o' ? "four".equals(s) : "five".equals(s);
        case 's':
            return s.charAt(1) == 'i' ? "six".equals(s) : "seven".equals(s);
        case 'e':
            return "eight".equals(s);
        case 'n':
            return "nine".equals(s);
        }
        return false;
    }
}

public class CheckerTester {
    private static final String[] TESTS = { "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen",

            new String("zero"), new String("one"), new String("two"), new String("three"),
            new String("four"), new String("five"), new String("six"), new String("seven"),
            new String("eight"), new String("nine"), new String("ten"), new String("eleven"),
            new String("twelve"), new String("thirteen"), new String("fourteen"), new String("fifteen"),
            new String("sixteen"), new String("seventeen"), new String("eighteen"), new String("nineteen") };

    public static void test(Checker checker) {
        final int N = 1_000_000;

        long start = System.nanoTime();

        for (int i = 0; i < N; i++)
            for (String test : TESTS)
                checker.contains(test);

        long end = System.nanoTime();

        System.out.printf("%s: %d ms\n", checker.getClass().getName(), (end - start) / 1_000_000);
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 2; i++) {
            System.out.println("---- Check #" + i);
            test(new HashSetChecker());
            test(new HashSetChecker2());
            test(new HashMapChecker());
            test(new TreeSetChecker());
            test(new OrChecker());
            test(new RefOrChecker());
            test(new SwitchChecker());
            test(new EmbeddedSwitchChecker());
            test(new CharSwitchChecker());
        }
    }

}