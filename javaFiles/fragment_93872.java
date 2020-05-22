String dob = "1985-03-01";

LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
dob = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

System.out.println(date);
System.out.println(dob);