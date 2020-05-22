DecimalStyle arabicDecimalStyle
            = DecimalStyle.of(arabicLocale).withZeroDigit('٠');
    DateTimeFormatter arabicDateFormatter
            = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                    .withLocale(arabicLocale)
                    .withDecimalStyle(arabicDecimalStyle);