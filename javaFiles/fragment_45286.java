public static void main(String[] args) {
    LocalDateTime firstTime = new LocalDateTime(2014, 10, 15, 4, 42);
    LocalDateTime secondTime = new LocalDateTime(2014, 12, 3, 5, 5);

    System.out.println("period Type: "+Period.fieldDifference(firstTime, secondTime).getPeriodType());
    Period period = new Period(firstTime, secondTime).normalizedStandard();
    System.out.println(period);
}