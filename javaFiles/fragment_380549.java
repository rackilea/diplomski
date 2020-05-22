public class CustomAuthenticationFilter extends FormAuthenticationFilter {
    private Map<String, String> loginUrlByUserAgent = new HashMap<String, String>();

    public void setLoginUrls(final Map<String, String> loginUrlByUserAgent) {
        this.loginUrlByUserAgent = loginUrlByUserAgent;
    }

    protected void redirectToLogin(final ServletRequest request, final ServletResponse response) throws IOException {
        final String loginUrl = getLoginUrl(request);
        WebUtils.issueRedirect(request, response, loginUrl);
    }

    private String getLoginUrl(final ServletRequest request) {
        // check user agent
        final String userAgent = getUserAgent(request);
        // and return appropriate login url
        return userAgent != null && loginUrlByUserAgent.containsKey(userAgent) ?
                loginUrlByUserAgent.get(userAgent) :
                getLoginUrl();
    }

    private String getUserAgent(final ServletRequest request) {
        // get "User-Agent" header
    }
}