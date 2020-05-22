public static String numtostring(int num) {
    StringBuilder sb = new StringBuilder();

    // Count number of digits in num.
    int len = String.valueOf(num).length();

    String[] wordarr1 = {"", "One ", "Two ", "Three ", "Four ",
        "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    String[] wordarr11 = {"", "Eleven ", "Twelve ", "Thirteen ",
        "Fourteen ", "Fifteen ", "Sixteen ",
        "Seventeen ", "Eighteen ", "Nineteen "};
    String[] wordarr10 = {"", "Ten ", "Twenty ", "Thirty ", "Forty ",
        "Fifty ", "Sixty ", "Seventy ", "Eighty ",
        "Ninety "};
    int tmp;
    if (num == 0) {
        sb.append("Zero");
    } else if (num >= 1000000) {
        System.err.println("Numbers > 999999 are not supported!");
        System.exit(1);
    } else {
        do {
            // Number greater than 999
            if (len > 3) {
                int n = num / 1000;
                sb.append(numtostring(n)).append("Thousand ");
                num = num % 1000;
                len -= String.valueOf(n).length();
            } else { // Number is less than 1000
                tmp = num / 100;
                if (tmp != 0) {
                    sb.append(wordarr1[tmp]);
                    sb.append("Hundred ");
                }
                tmp = num % 100;
                if (tmp / 10 == 1 && tmp % 10 != 0) {
                    sb.append(wordarr11[tmp % 10]);
                } else {
                    sb.append(wordarr10[tmp / 10]);
                    sb.append(wordarr1[tmp % 10]);
                }
                len = 0;
            }
        } while (len > 0);
    }
    return sb.toString();
}