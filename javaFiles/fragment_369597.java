public static void printCal(String[] calender) {
    for (int i=1;i<calender.length;i++) {
        String event = (calendar[i] == null) ? "Holding Text" : calendar[i];
        System.out.println("Day: " + i + " " + " Event: " + event);
    }
}