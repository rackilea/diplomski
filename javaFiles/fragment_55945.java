public static class GetCountries {

    private static final String API_URL = "https://restcountries.eu/rest/v2/all";
    private static CountryDetails[] countryDetails;

    public static CountryDetails[] getDetails() {

        //uses cached countryDetails once it gets loaded
        if (countryDetails != null) {
            return countryDetails;
        }

        StringBuilder jsonString = new StringBuilder();
        HttpURLConnection urlConnection;
        try {
            URL urlObject = new URL(API_URL);

            urlConnection = (HttpURLConnection) urlObject.openConnection();
            urlConnection.setRequestMethod(HttpMethod.GET.name());

            String inputLine = "";

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((inputLine = bufferedReader.readLine()) != null) {
                jsonString.append(inputLine);
            }
            urlConnection.getInputStream().close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        Countries[] countries = new Gson().fromJson(jsonString.toString(), Countries[].class);

        countryDetails = new CountryDetails[countries.length];
        for (int i = 0; i < countries.length; i++) {
            countryDetails[i] = new CountryDetails(
                    countries[i].getAlpha2Code(),
                    countries[i].getAlpha3Code(),
                    countries[i].getName()
            );
        }
        return countryDetails;
    }
}