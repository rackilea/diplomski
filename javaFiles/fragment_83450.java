ZoneId z = ZoneId.of("Africa/Nairobi");
    ZonedDateTime zdt = ZonedDateTime.now(z);
    System.out.println("Date         " + zdt.toLocalDate());
    System.out.println("Year         " + zdt.getYear());
    System.out.println("Month        " + zdt.getMonth());
    System.out.println("Day of month " + zdt.getDayOfMonth());