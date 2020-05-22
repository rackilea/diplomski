public static String hailstones(int n) {
    String result = "";
    while (n != 1) {
        result += Integer.toString(n) + " ";
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = n * 3 + 1;
        }
    }
    result += "1";
    return result;
}