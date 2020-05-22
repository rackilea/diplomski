public class AccessTest {
    List<String> countries = Arrays.asList(
        "www.website.com", 
        "www.website.co.uk", 
        "www.website.ch", 
        "www.website.com.fr");

    Map<Users, List<String>> userCountries = new HashMap<Users, List<String>>();
    userCountries.put(UserFixture.userUSA, countries);
    userCountries.put(UserFixture.userUK, countries);
    userCountries.put(UserFixture.userChina, countries);
    userCountries.put(UserFixture.userFrance, countries);

    public static test() {
        // u = user; c = country 
        userCountries.forEach((u, c) ->
            c.forEach( country ->
                goToUrl(country);
                login(u);
                // Write the rest of the test below
            )
        )
    }
}