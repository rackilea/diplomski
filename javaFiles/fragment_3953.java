public class SiteMinderFilter extends RequestHeaderAuthenticationFilter {

    private String rolesRequestHeader;
    private String rolesDelimiter;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, NullPointerException {

        String roles = (String)  ((HttpServletRequest)request).getHeader(getRolesRequestHeader());
        String[] rolesArray = roles.split(rolesDelimiter);

        Collection<SimpleGrantedAuthority> auth = new ArrayList<SimpleGrantedAuthority>();
        for (String s : rolesArray) {               
            auth.add(new SimpleGrantedAuthority(s));
        }

        SiteMinderUserDetails userDetails = new SiteMinderUserDetails();
        userDetails.setUsername((String) super.getPreAuthenticatedPrincipal(((HttpServletRequest)request)));
        userDetails.setAuthorities(auth);

        AuthenticationImpl authentication = new AuthenticationImpl();
        authentication.setAuthenticated(true);
        authentication.setAuthorities(auth);
        authentication.setPrincipal(userDetails);
        authentication.setCredentials(super.getPreAuthenticatedCredentials(((HttpServletRequest)request)));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        super.doFilter(request, response, chain);
    }

    public SiteMinderFilter() {
        super();        
    }

    @Override
    public void setPrincipalRequestHeader(String principalRequestHeader) {
        super.setPrincipalRequestHeader(principalRequestHeader);
    }

    public void setRolesRequestHeader(String rolesRequestHeader) {
        this.rolesRequestHeader = rolesRequestHeader;
    }

    public String getRolesRequestHeader() {
        return rolesRequestHeader;
    }


    public void setRolesDelimiter(String rolesDelimiter) {
        this.rolesDelimiter = rolesDelimiter;
    }

    public String getRolesDelimiter() {
        return rolesDelimiter;
    }
}