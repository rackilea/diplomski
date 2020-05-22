// runnable example

String newDate = "2017-04-30 23:59";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
LocalDateTime forDate = LocalDateTime.parse(newDate, formatter);
System.out.println(forDate);