interface Counter {
    int count(String hand);
}
class FirstCounter implements Counter {
    public int count(String hand) {
        String[] cards = hand.split(hand);
        if(hand.contains("/")){
            cards = hand.split("/");
        } else if (hand.contains("-")){
            cards = hand.split("-");
        } else if (hand.contains(" ")){
            cards = hand.split(" ");
        } else {
            // Prefer to fail fast unless your requirement
            // really is to only print "incorrect format"
            //System.out.println("Incorrect format!");
            throw new RuntimeException("Incorrect format!");
        }
        if (hand.endsWith("-") || hand.endsWith("/") || hand.endsWith(" ")) {
            return cards.length;
        }
        return cards.length - 1;
    }    
}
class SecondCounter implements Counter {
    public int count(String hand) {
        char[] delims = {'/', ' ', '-'};
        int result = 0;
        for (char delim : delims) {
            for (int i = 0; i < hand.length(); i++) {
                if (hand.charAt(i) == delim) {
                    ++result;
                }
            }
        }
        if (result == 0) {
            // This is a hack or inconsistent with requirements,
            // but necessary to match original posted code behavior
            throw new RuntimeException("Incorrect format!");
        }
        return result;
    }
}
class Main {
    private static int testCount = 0;

    static void realAssert(boolean condition) {
        if (!condition) {
            throw new AssertionError("Java has no real assert");
        }
    }

    static void test(Counter counter) {
        ++testCount;
        try {
            realAssert(counter.count("6s/3d/2H/13c/Ad") == 4);
            realAssert(counter.count("6s-3d-2H-13c-Ad") == 4);
            realAssert(counter.count("6s 3d 2H 13c Ad") == 4);
            // Don't forget boundary conditions
            realAssert(counter.count("6s-3d-2H-13c-") == 4);
            realAssert(counter.count("6s/3d/2H/13c/") == 4);
            realAssert(counter.count("6s 3d 2H 13c ") == 4);
            realAssert(counter.count("-6s-3d-2H-13c-") == 5);
            realAssert(counter.count("/6s/3d/2H/13c/") == 5);
            realAssert(counter.count(" 6s 3d 2H 13c ") == 5);
            realAssert(counter.count("--") == 2);
            // Remember to test error conditions
            try {
                counter.count("foobar");
                realAssert(false);
            } catch (RuntimeException e) {
                // Catching RuntimeException is normally bad
                // done only as example.
                // Also normally bad, this is an empty catch
                // block. These are sometimes useful, but always
                // at least add a comment that explains that this
                // catch block really should be empty, in this case
                // because the test was meant to throw an Error.
            }
            try {
                counter.count("foo/bar-baz");
                // Left as exercise for reader, based on question
                // it is possible this should be disallowed.
                //realAssert(false);
            } catch (RuntimeException e) {
                // Ditto above, intentionally empty catch
            }
            System.out.println("Test " + testCount + " succeeded");
        }
        catch (Error e) {
            // XXX: Don't catch Error in non-example code
            System.out.println("Test " + testCount + " failed");
            /* Normally don't use printStackTrace either */
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test(new FirstCounter());
        test(new SecondCounter());
    }
}