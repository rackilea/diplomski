String input = "29-NOV-11 06.05.41.831000000 AM";

input = input
        .replaceFirst(
                "(\\d+-\\w+-\\d+\\s\\d+\\.\\d+\\.\\d+\\.\\d{3})\\d{6}(\\s(\\w+))",
                "$1$2");
try {
    SimpleDateFormat sdf = new SimpleDateFormat(
            "dd-MMM-yy HH.mm.ss.SSS aa");

    Date date = sdf.parse(input);
    System.out.println(sdf.format(date));

} catch (ParseException e) {
    e.printStackTrace();
}