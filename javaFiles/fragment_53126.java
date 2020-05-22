Pattern twoDates = Pattern.compile("(\\d+/\\d+/\\d+)\\W+(\\d+/\\d+/\\d+)");
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");

    String[] dateStrings = {
            "12/12/2018 13/12/2018",
            "12/12/2018-13/12/2018",
            "12/12/2018 - 13/12/2018"
    };
    for (String dateString : dateStrings) {
        Matcher m = twoDates.matcher(dateString);
        if (m.matches()) {
            try {
                String ds1 = m.group(1);
                LocalDate ld1 = LocalDate.parse(ds1, dateFormatter);
                String ds2 = m.group(2);
                LocalDate ld2 = LocalDate.parse(ds2, dateFormatter);
                System.out.println("First date: " + ld1 + " Second date: " + ld2);
            } catch (DateTimeParseException dtpe) {
                System.out.println("Invalid date in string " + dateString
                        + ": " + dtpe.getMessage());
            }
        } else {
            System.out.println("Not two dates: " + dateString);
        }
    }