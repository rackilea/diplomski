String startDate1 = "2017-03-23";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

LocalDate date = LocalDate.parse(startDate1, formatter);

java.sql.Date sqlDate = java.sql.Date.valueOf(date);