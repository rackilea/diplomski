List<LocalDate> dateList = new ArrayList<>();
dateList.add(LocalDate.of(2017, 6, 2));
dateList.add(LocalDate.of(2017, 6, 3));
dateList.add(LocalDate.of(2017, 6, 4));
dateList.add(LocalDate.of(2017, 6, 5));
LocalDate today = LocalDate.now();

System.out.println(count(dateList, today)); // 4