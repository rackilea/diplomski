public static void calendarBug() {
    for (int i=0 ; i<6 ; i++) {
        Calendar c = Calendar.getInstance();

        c.setTimeZone(TimeZone.getTimeZone("Canada/East-Saskatchewan"));
        c.clear();
        c.set(2015, 2, 27, i, 0);
        System.out.println(c.getTime());
    }
}

Fri Mar 27 08:00:00 EET 2015
Fri Mar 27 09:00:00 EET 2015
Fri Mar 27 10:00:00 EET 2015
Fri Mar 27 11:00:00 EET 2015
Fri Mar 27 12:00:00 EET 2015
Fri Mar 27 13:00:00 EET 2015