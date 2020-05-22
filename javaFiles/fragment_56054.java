DateTimeFormatter docDateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    String documentDate = "03/03/2018";
    DateTimeFormatter formatIreland = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
            .withLocale(localeIreland);
    System.out.println(LocalDate.parse(documentDate, docDateFormatter).format(formatIreland));