LocalDate localDate = LocalDate.parse("2017-04-27", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
long daysDiff = localDate.until(LocalDate.now(), ChronoUnit.DAYS);

System.out.println(daysDiff);
if (daysDiff >= 30){
    System.out.println("haha");
}