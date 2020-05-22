public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("123qq11 1q1 11q1 1qq11 1q1 11q1");
    int j = 0;
    int i = 0;
    while (i < sb.length()) {
        while (i < sb.length()) { // while 2nd

            if (sb.charAt(i) == 'q') {
                j = i;
                break;
            }
            i++;
        }

        sb.replace(j, j + 1, "Q");
        System.out.println(sb);
    }
}