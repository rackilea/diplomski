public static void printMonth(int numDays, int startDay) {
    System.out.println("So  Mo  Di  Mi  Do  Fr  Sa");

    int column = 0;
    for(int day = 1 - startDay; day <= numDays; day++) {
        System.out.print(day > 0 ? String.format("%2d  ", day) : "    ");
        if (++column % 7 == 0) System.out.println();
    }

    System.out.println();
}