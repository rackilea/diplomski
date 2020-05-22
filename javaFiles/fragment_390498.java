public class LogIn {

    @Test
    void test() throws Exception {
        String[] urls = new String[3];

        urls[0] = "site.com/us/en";
        urls[1] = "site.com/ca/en";
        urls[2] = "site.com/au/en";

        String[] titles = new String[3];
        titles[0] = "Site Title - US";
        titles[1] = "Site Title - CA";
        titles[2] = "Site Title - AU";

        for (int i = 0; i < urls.length; i++) {
            checkTitle(urls[i], titles[i]);
        }
    }

    void checkTitle(String url, String expected) {
        openbrowser(url);

        //------- sign in from the sign in page--------//
        RegisteredSignIn();

        CheckTitle(expected);

        quitbrowser();
    }
}