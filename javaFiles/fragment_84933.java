String str = "Wed 20th May";
    ZoneId zone = ZoneId.of("Europe/London");
    LocalDate today = LocalDate.now(zone);
    int currentYear = today.getYear();
    LocalDate datetext = null;
    final int maxYearsFromToday = 3;
    for (int year = currentYear; year <= currentYear + maxYearsFromToday; year++) {
        DateTimeFormatter parseFormatter = new DateTimeFormatterBuilder()
                .appendPattern("EEE d['st']['nd']['rd']['th'] MMMM")
                .parseDefaulting(ChronoField.YEAR, year)
                .toFormatter(Locale.ENGLISH);

        try {
            datetext = LocalDate.parse(str, parseFormatter);
            System.out.println("Day of week matched for year " + year);
            break;
        } catch (DateTimeParseException dtpe) {
            // Ignore, try next year
        }
    }

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM", Locale.ENGLISH);
    if (datetext == null) {
        System.out.println("Could not parse date;"
                + " possibly the day of week didn’t match for any year in the range "
                + currentYear + " through " + (currentYear + maxYearsFromToday));
    } else if (datetext.isBefore(today) || datetext.isAfter(today.plusYears(maxYearsFromToday))) {
        System.out.println("Date is out of range");
    } else {
        System.out.println("Successfully parsed: " + datetext.format(outputFormatter));
    }