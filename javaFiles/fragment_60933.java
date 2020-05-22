public static void main(String[] args) {
    LocalDate start = LocalDate.of(2016, 01, 01);
    Period period = Period.between(start, start.plus(Period.ofMonths(1)));
    System.out.println(period.getDays());   // prints 0
    System.out.println(period.getMonths()); // prints 1
}