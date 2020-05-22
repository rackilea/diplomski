DateTime day = new DateTime(2015,10,15,0,0);
    System.out.println(day); // 2015-10-15T00:00:00.000+02:00
    day = day.plus(Period.parse("P15D"));
    System.out.println(day); // 2015-10-30T00:00:00.000+01:00
    day = day.plus(Period.parse("P5M"));
    System.out.println(day); // 2016-03-30T00:00:00.000+02:00
    day = day.plus(Period.parse("P5Y"));
    System.out.println(day); // 2021-03-30T00:00:00.000+02:00
    day = day.plus(Period.parse("P3W"));
    System.out.println(day); // 2021-04-20T00:00:00.000+02:00