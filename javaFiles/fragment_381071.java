public class UcozApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "http://uapi.ucoz.com/accounts/oauthauthorizetoken?oauth_token=%s";
    protected UcozApi() {
    }
    private static class InstanceHolder {
        private static final UcozApi INSTANCE = new UcozApi();
    }

    public static UcozApi instance() {
        return InstanceHolder.INSTANCE; }

    @Override
    public String getAccessTokenEndpoint(){
        return "http://uapi.ucoz.com/accounts/oauthgetaccesstoken"; }

    @Override
    public String getRequestTokenEndpoint() {
        return "http://uapi.ucoz.com/accounts/oauthgetrequesttoken"; }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken()); }

    @Override
    public TokenExtractor<OAuth1AccessToken> getAccessTokenExtractor() {
           return OAuth1AccessUcozTokenExtractor.instance();
    }

    @Override
    public TokenExtractor<OAuth1RequestToken> getRequestTokenExtractor() {
        return OAuth1RequestUcozTokenExtractor.instance();
    }
}