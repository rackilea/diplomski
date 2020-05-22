public static void checkTimes(String start, String end) {
    try {
        if (LocalTime.parse(start).isBefore(LocalTime.parse(end))) {
            System.out.println("test1");// future date - good
        } else {
            System.out.println("fail2");// old date - bad
        }
    } catch (DateTimeParseException dtpe) {
        System.out.println("error");
    }
}