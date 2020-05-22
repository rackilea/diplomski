DateTime startOfMonth = new DateTime(2013, 1, 1, 00, 00, 00);
System.out.println(startOfMonth.toString());
for (int i = 0; i < 12; i++) {
    startOfMonth = startOfMonth.plusMonths(1);
    DateTime endOfMonth = startOfMonth.minusDays(1); // magic here
    System.out.println(startOfMonth + "-" + endOfMonth);
}