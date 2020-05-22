ZonedDateTime value = ZonedDateTime.now(ZoneOffset.UTC);
System.out.println(value.get(ChronoField.NANO_OF_SECOND));

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
long time = Long.parseLong(formatter.format(value)) * 100;
System.out.println(time);