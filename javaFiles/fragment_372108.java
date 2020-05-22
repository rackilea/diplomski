public static void printCalendar(int monday, int numDays) {
    if (monday > 7 || monday < 1) throw new IllegalArgumentException("Invalid monday.");
    if (numDays > 31 || numDays < 1 || numDays < monday) throw new IllegalArgumentException("Invalid numDays.");

    System.out.print("Mon\t");
    System.out.print("Tue\t");
    System.out.print("Wed\t");
    System.out.print("Thur\t");
    System.out.print("Fri\t");
    System.out.print("Sat\t");
    System.out.print("Sun\t");
    System.out.println();

    int padding = (7 - (monday - 1)) % 7;

    for (int i = 0; i < padding; i++) {
        System.out.print(" \t");
    }

    for (int day = 1; day <= numDays; day++) {
        if ((padding + day) % 7 == 0)
            System.out.println(day + "\t");
        else
            System.out.print(day + "\t");
    }
}