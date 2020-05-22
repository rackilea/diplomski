public static int toDecimal(String base2) {
    int sum=0;
    int i = 0;
    for (int k = base2.length() - 1; k >= 0; k--) {
        sum += Integer.parseInt(String.valueOf(base2.charAt(k))) << i;
        i++;
    }
    return sum;
}