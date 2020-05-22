Locale arabicLocale = Locale.forLanguageTag("ar");
    DateTimeFormatter arabicDateFormatter
            = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                    .withLocale(arabicLocale)
                    .withDecimalStyle(DecimalStyle.of(arabicLocale));
    LocalDate today = LocalDate.now(ZoneId.of("Asia/Muscat"));
    System.out.println(today.format(arabicDateFormatter));