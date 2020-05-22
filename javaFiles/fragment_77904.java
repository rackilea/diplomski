public static void spiderNavigator(String str) {
    if (str == null || str.length() == 0)
        return;
    int[] initial = {0, 0};
    int angle = 90;
    char[] ch = str.toCharArray();
    for (char c : ch) {
        if (c == 'L') {
            angle = (angle + 90) % 360;
        } else if (c == 'R') {
            angle = (angle - 90) % 360;
        } else if (c == 'F') {
            initial[0] += (int) Math.cos(Math.toRadians(angle));
            initial[1] += (int)  Math.sin(Math.toRadians(angle));
        }
    }

    System.out.println(Arrays.toString(initial));
}