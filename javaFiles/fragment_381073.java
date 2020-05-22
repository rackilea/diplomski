public class OAuth1AccessUcozTokenExtractor extends AbstractOauth1UcozTokenExtractor<OAuth1AccessToken> {

    protected OAuth1AccessUcozTokenExtractor() {
    }

    @Override
    protected OAuth1AccessToken createToken(String token, String secret, String response) {
        return new OAuth1AccessToken(token, secret, response);
    }

    private static class InstanceHolder {

        private static final OAuth1AccessUcozTokenExtractor INSTANCE = new OAuth1AccessUcozTokenExtractor();
    }

    public static OAuth1AccessUcozTokenExtractor instance() {
        return InstanceHolder.INSTANCE;
    }
}