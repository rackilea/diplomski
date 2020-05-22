LocalDateTime  today = LocalDateTime.parse("2018-07-17T13:45:00");
LocalDateTime  expiration = LocalDateTime.parse("2018-07-18T11:00:00");
LocalDate todayDate = today.toLocalDate();
LocalDate expirationDate = expiration.toLocalDate();
long days = todayDate.until(expirationDate, ChronoUnit.DAYS);
System.out.println(days);