public static String formatResolutionTime(String startDateString) {
    DateFormat dfParse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ"); //Format for parsing the Input string
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); //Format for formatting the output
    Date startDate = null;

    try {
        startDate = dfParse.parse(startDateString);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    String newDateString = df.format(startDate);
    System.out.println(newDateString);
    return newDateString;

}