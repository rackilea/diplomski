private Filter ssoFilter(ClientResources client, String path) {
        OAuth2ClientAuthenticationProcessingFilter clientFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
        .......
        clientFilter.setAuthenticationSuccessHandler(new UrlParameterAuthenticationHandler());
        return clientFilter;
    }

    public class UrlParameterAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
            String targetUrl = determineTargetUrl(request, response);

            if (response.isCommitted()) {
                logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
                return;
            }

            String queryString = HttpUtils.removeParams(request.getQueryString(), "state", "code");
            targetUrl = !StringUtils.isEmpty(queryString) ? targetUrl + "?" + queryString : targetUrl;
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }

    }