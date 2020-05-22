public static void main(String[] args) throws ParseException {
    test("Nov.11,2018 11:00am", "Mar.5,2019 10:00am");
    test("Nov.11,2018 11:00am", "Mar.5,2019 3:00pm");
}
public static void test(String d1, String d2) throws ParseException {
    SimpleDateFormat fmt = new SimpleDateFormat("MMM.d,yyyy hh:mma");
    System.out.println("[" + d1 + "] , [" + d2 + "] = " +
            daysBetweenDatesWithSign(fmt.parse(d1), fmt.parse(d2)));
}