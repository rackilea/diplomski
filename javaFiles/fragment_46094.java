public class JsoupTest {
    public static void main(String args[]) throws URISyntaxException {
        try {

            String urlLogIn = "https://invest.firstrade.com/cgi-bin/login";

            // Put the url that you see when you have logged in.
            String urlUnderTest = "https://invest.firstrade.com/cgi-bin/main#/cgi-bin/acctpositions"; 

            // Create a "session" map here to persists cookies across all requests
            Map<String, String> session = new HashMap<String, String>();

            // get initial login form
            Response loginForm = Jsoup.connect(urlLogIn)
                    .userAgent(agent)
                    .method(Method.GET)
                    .execute();

            // initialize session
            session = loginForm.cookies();



            print("started");



            // data map containing all the parameters and its values found in the form
            Map<String, String> mapParams = new HashMap<String, String>();
            mapParams.put("redirect", "");
            mapParams.put("ft_locale", "en-us");
            mapParams.put("login.x", "Log In");
            mapParams.put("username", "MY_USERNAME");
            mapParams.put("password", "MY_PASSWORD");
            mapParams.put("destination_page", "acctpositions");

            // With this you login and a session is created
            Connection.Response res = Jsoup.connect(urlLogIn)
                    .userAgent(agent)
                    .data(mapParams)
                    .cookies(session)
                    .method(Method.POST)
                    .execute();

            // update session after login
            session.putAll(loginResp.cookies());



            print("done");



            // The snippet from "started" to "done" is a full cycle
            // From here on every request is basically as the snippet above
            // For example:
            mapParams = new HashMap<String, String>();
            mapParams.put("other required form data", "DATA");

            resp = Jsoup.connect(urlUnderTest)
                    .userAgent(agent)
                    .data(mapParams)
                    .referrer("https://invest.firstrade.com/cgi-bin/main") // sometimes referrer is necessary
                    .cookies(session)
                    .method(Method.POST)
                    .execute();
            session.putAll(resp.cookies());

            // Then you start your crawler stuff
            Document doc = resp.parse();
            System.out.println(doc.title());
            print(doc.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}