public class MyAuthenticator implements Authenticator {

    private static int MAX_AUTHENTICATE_TRIES = 3;

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        if (responseCount(response) >= MAX_AUTHENTICATE_TRIES) {
            return null; // If we've failed 3 times, give up. - in real life, never give up!!
        }
        String credential = Credentials.basic(AUTHTOKEN_USERNAME, AUTHTOKEN_PASSWORD);
        return response.request().newBuilder().header("Authorization", credential).build();
    }

    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }


}