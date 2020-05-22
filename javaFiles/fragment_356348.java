DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
    String sDate1 = "20181120";
    LocalDate date1 = LocalDate.parse(sDate1, dtf);
    LocalDate end = date1.plusYears(1);
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> second = new ArrayList<>();
    ArrayList<String> third = new ArrayList<>();
    while (!date1.isAfter(end)) {
        first.add(dtf.format(date1) + "*_A.dat");
        second.add(dtf.format(date1) + "_B.dat");
        third.add(dtf.format(date1) + "__C.dat");
        date1 = date1.plusDays(1);
    }

    // Let’s also see some of the result
    first.forEach(System.out::println);