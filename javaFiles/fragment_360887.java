DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").withLocale(Locale.US);
    DateTime x = dtf.parseDateTime("30/03/2008 00:00:00");

    DateTimeFormatter parser = DateTimeFormat.fullDateTime();
    System.out.println("Start:"+parser.print(x));

    DateTime y = x.plusHours(4);

    System.out.println("After add of 4:"+parser.print(y));