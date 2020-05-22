public static int pow(int x1, int x2) {
    if (x1 == 0) return 0;
    if (x2 == 0) return 1;
    int exp = x2;
    int y = x1;
    int multi;

    while (exp > 1) {
        multi = x1;
        int temp = y;
        int loopTempY = temp;
        while (multi != 1) {
            while (temp != 0) {
                y++;
                temp--;
            }
            temp = loopTempY;
            multi--;
        }
        exp--;

        System.out.println(y);
    }

    return y;
}