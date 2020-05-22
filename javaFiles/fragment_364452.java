DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern(shortPattern.replaceAll("y","")))
                .appendValueReduced(ChronoField.YEAR, 2, 4, LocalDate.now().minusYears(80))
                .appendOptional(DateTimeFormatter.ofPattern(shortPattern.replaceAll("y","")))
                .toFormatter();

TemporalAccessor temporalAccessor = formatter.parseBest("92-07-09", LocalDate::from, LocalDateTime::from);
System.out.println(temporalAccessor); //1992-07-09