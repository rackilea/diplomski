DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.u");
    System.out.println(LocalDate.parse("02.05.2019", dateFormatter));
    System.out.println(LocalDate.parse("3.5.2019", dateFormatter));
    System.out.println(LocalDate.parse("4.05.2019", dateFormatter));
    System.out.println(LocalDate.parse("06.5.2019", dateFormatter));
    System.out.println(LocalDate.parse("15.12.2019", dateFormatter));