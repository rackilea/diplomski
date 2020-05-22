private static final String csv = "World Development Indicators\n"
    + "Number of countries,4\n"
    + "Country Name,2005,2006,2007\n"
    + "Bangladesh,6.28776238,13.20573922,23.46762823\n"
    + "\"Bahamas,The\",69.21279415,75.37855087,109.340767\n"
    + "Brazil,46.31418452,53.11025849,63.67475185\n"
    + "Germany,94.55486999,102.2828888,115.1403608\n";

public static String[] getCountryNames() throws Exception {
    List<String> countryNames = new ArrayList<>();

    //BufferedReader br = new BufferedReader(new FileReader(fileName));
    BufferedReader br = new BufferedReader(new StringReader(csv));
    br.readLine();
    br.readLine();
    br.readLine();

    String line = br.readLine();
    while (line != null && !line.isEmpty()) {
        String[] countries = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        countryNames.add(countries[0]);
        line = br.readLine();
    }

    System.out.println(countryNames);
    return countryNames.toArray(new String[0]);
}