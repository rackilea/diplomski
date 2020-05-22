DateTimeFormatter inputFormatter = 
        new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .appendPattern("dd-MMM-uuuu")
        .toFormatter(Locale.ENGLISH)
;

DateTimeFormatter outputformatter =
        DateTimeFormatter.ofPattern("MMMMdd,uuuu", Locale.ENGLISH)
;

String input = "31-AUG-2018";
LocalDate date = LocalDate.parse(input, inputFormatter);