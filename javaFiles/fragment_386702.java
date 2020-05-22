public static String factorial(int x) {
    int result = 1;
    String run = null;
    for (int n = x; n > 0; n--) {
        result = n * result;
        run = (x + ", " + result);
    }
    return run;
}