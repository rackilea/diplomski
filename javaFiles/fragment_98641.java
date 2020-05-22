ZonedDateTime zdt1 = getDate("2011-12-03T10:15:30+01:00[Europe/Paris]");
    ZonedDateTime zdt2 = getDate("2017-11-23T23:43:45-05:00[America/New_York]");

    long diffYears = ChronoUnit.YEARS.between(zdt1, zdt2);
    System.out.println("Difference is " + diffYears + " years");

    long diffMilliseconds = ChronoUnit.MILLIS.between(zdt1, zdt2);
    System.out.println("Difference is " + diffMilliseconds + " ms");