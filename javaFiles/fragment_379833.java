public class CustomAuthenticationDetails extends WebAuthenticationDetails {
    private final Logger log = LoggerFactory.getLogger(CustomAuthenticationDetails.class);
    private final String URI;
    private final String sessionId;
    public CustomAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.URI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        this.sessionId = (session != null) ? session.getId() : null;
    }

    public String getURI() {
        return URI;
    }

    public String getSessionId() {
        return sessionId;
    }
}