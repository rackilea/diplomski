public static void printMonthBody(int m, int d, int y) {
    int i = 0;
    int x = 0;

    int startDay = -getStartDay(m, d, y);
    for (int date = startDay; date < d; date++) {
        if (date <= 0) {
            System.out.printf("%3s ", "");
        } else {
            System.out.printf("%3d ", date);
        }

        x++;
        if (x % 7 == 0) {
            System.out.println("");
        }
    }
}