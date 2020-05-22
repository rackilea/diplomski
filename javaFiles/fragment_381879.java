String[] dates = {"1981-1990", "2020-02-25", "1971-1980", "1998-02-25", "1991-2000"};
for (String date : dates) {
    if (date.matches("\\d{4}-\\d{4}")) {
        String[] split = date.split("-");

        if (Year.parse(split[0]).isBefore(Year.parse(split[1]))) {
            System.out.println("Correct range");
        } else {
            System.out.println("Wrong range");
        }
    } else {
        try {
            LocalDate.parse(date);
            System.out.println("Correct date");
        } catch (DateTimeParseException ex) {
            System.out.println("Wrong date");
        }
    }
}