public static int getPeriod(String str) {
    int len = str.length();
    int i;

    for (i = 1; i <= len/2; i++) {
        String period = str.substring(0, i);
        String tmp = str;
        boolean flag = true;

        while (flag && tmp.length() > 0) {
            if (tmp.startsWith(period)) {
                tmp = tmp.substring(i);
            } else {
                flag = false;
            }
        }

        if (flag == true) {
            return i;
        }
    }
    return 0;
}