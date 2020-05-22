public static void main(String[] args) {
   LocalDate now = LocalDate.now();
   LocalDate start = now.minusDays(5);
   LocalDate end = now.plusDays(5);

   System.out.println("Now: " + now + ", start: " + start + ", end: " +end);
   List<LocalDate> list = buildDateRange(start, end, now);

   for (LocalDate d : list) {
       System.out.println(d);
   }
}