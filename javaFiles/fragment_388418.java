public static boolean isArmstrong(int val) {
    char[] chars = String.valueOf(val).toCharArray();
    int count = 0;
    for (int i = 0; i < chars.length; i++) {
        int digit = chars[i] - '0';
        count += Math.pow(digit, chars.length);
    }
    return (count == val);
}