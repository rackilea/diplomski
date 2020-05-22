String[] ranges = {"1981-1990", "1971-1980", "1991-2000"};
for (String range : ranges) {
    String[] dates = range.split("-");
    if (Year.parse(dates[0]).isBefore(Year.parse(dates[1]))) {
        System.out.println("Correct range");
    } else {
        System.out.println("Wrong range");
    }
}