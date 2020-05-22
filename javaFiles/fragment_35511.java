private static String intToHex(int n) {
    int temp = n % 16;
    String digit = "";

    if (temp < 10) digit += temp;
    if (temp > 9) {
        switch (temp) {
            case 10: digit="A"; break;
            case 11: digit="B"; break;
            case 12: digit="C"; break;
            case 13: digit="D"; break;
            case 14: digit="E"; break;
            case 15: digit="F"; break;
        }
    }
    if ( (n-temp)/16 == 0 ) return digit;
    if (n > 0) return intToHex((n-temp)/16) + digit;
    return "";
}

public static void main(String[] args) {
    System.out.println(intToHex(1234));
    System.out.println(intToHex(257));
    System.out.println(intToHex(0));
}