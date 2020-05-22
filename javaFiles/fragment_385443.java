Pattern datePattern = Pattern.compile("\\d{1,2} de [a-zç]{4,9} de \\d{4}");
    DateTimeFormatter portugueseDateFormatter
            = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                    .withLocale(Locale.forLanguageTag("pt-BR"));

    String[] differentStrings = {
            "Portaria n° 200, 28 de janeiro de 2018.",
            "Portaria n° 200, 28 de janeiro de 2018 da Republica Brasileira.",
            "Portaria n° 200 28 de janeiro de 2018.",
            "Portaria n° 200 2017/2018 de 28 de janeiro de 2018."
    };

    for (String s : differentStrings) {
        Matcher m = datePattern.matcher(s);
        if (m.find()) {
            String dateString = m.group();
            LocalDate date = LocalDate.parse(dateString, portugueseDateFormatter);
            System.out.println("Date found: " + date);
        } else {
            System.out.println("No date found in " + s);
        }
    }