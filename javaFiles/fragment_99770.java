public static String recursion (int n) {
    //set s to the number n
    String s = "" + n;

    if (n != 1) {
        //change position of the separator
        if (n % 2 == 0) return s + ", " + recursion(n / 2);
        //change position of the separator
        else return s + ", " + recursion((3 * n) + 1);
    }
    else return s;
}