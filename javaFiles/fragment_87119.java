public static boolean checkPrime(long a) {
    if (a % 2 == 0)
        return a == 2;
    for (int i = 3; i <= (int) Math.sqrt(a); i = i + 2) {
        if (a % i == 0) {
            return false;
        }
    }
    return true;
}

public static boolean checkPrime2(long a) {
    if (a % 2 == 0 || a % 3 == 0 || a % 5 == 0) {
        return a <= 3 || a == 5;
    }
    for (int i = 6, max = (int) Math.sqrt(a); i <= max; i = i + 6) {
        if (a % (i + 1) == 0 | a % (i + 5) == 0) {
            return false;
        }
    }
    return true;
}

public static void time(String desc, BooleanSupplier run) {
    long start = System.nanoTime();
    boolean result = run.getAsBoolean();
    if (!result)
        throw new AssertionError();
    long time = System.nanoTime() - start;
    System.out.printf("%s took %.3f mill-seconds%n", desc, time / 1e6);
}

public static void main(String... args) {
    for (int i = 2; i < 1000; i++) {
        boolean a = checkPrime(i);
        boolean b = checkPrime2(i);
        if (a != b)
            throw new AssertionError(i);
    }

    for (int i = 0; i < 3; i++) {
        time("checkPrime", () -> checkPrime(9999999998987L));
        time("checkPrime2", () -> checkPrime2(9999999998987L));
    }
}