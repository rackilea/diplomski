public class TenantFilter implements Filter {

    private final Pattern pattern = Pattern.compile(";\\s*tenant\\s*=\\s*(\\w+)");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String tenant = matchTenantSystemIDToken(httpRequest.getRequestURI());
        Tenant.setCurrentTenant(tenant);
        try {
            chain.doFilter(request, response);
        } finally {
            Tenant.clearCurrentTenant();
        }
    }

    private String matchTenantSystemIDToken(final String uri) {
        final Matcher matcher = pattern.matcher(uri);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}