// Korean timezone
ZoneId zone = ZoneId.of("Asia/Seoul");
// current date in Korea timezone
LocalDate currentDateInKorea = LocalDate.now(zone);
// formatter (use English locale to correctly use English name for day of week)
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEEE M/dd/yyyy", Locale.ENGLISH);
System.out.println(fmt.format(currentDateInKorea));