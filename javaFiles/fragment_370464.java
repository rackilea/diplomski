List<LocalDate> dates = new ArrayList<>();
dates.add(LocalDateTime.parse("2016-08-18T05:18:24").toLocalDate());
dates.add(LocalDateTime.parse("2016-08-17T05:18:24").toLocalDate());
dates.add(LocalDateTime.parse("2016-08-19T17:00:24").toLocalDate());

System.out.println(dates.stream().anyMatch(LocalDate.now()::equals));