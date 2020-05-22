LocalDateTime dt1 = LocalDateTime.of(2014, 9, 11, 10, 0);
LocalDateTime dt2 = LocalDateTime.of(2014, 9, 11, 12, 0);

Duration duration = Duration.between(dt1, dt2);
System.out.println(duration.toDays());
System.out.println(duration.toHours());
System.out.println(duration.toMinutes());
System.out.println(duration.getSeconds());