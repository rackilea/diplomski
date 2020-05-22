public static void main(String []args){
    LocalDate zero = LocalDate.of(1970, Month.JANUARY, 1);
    LocalDate ld = LocalDate.now();
    System.out.println(ld);
    long days = zero.until(ld,ChronoUnit.DAYS);
    System.out.println("days: "+days);
    LocalDate ld2 = zero.plusDays(days);
    System.out.println(ld2);
 }