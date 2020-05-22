@Component
public class RequesEndpointURLExtractor {

    public String getCurrentURL() {
        TransportContext ctx = TransportContextHolder.getTransportContext();
        HttpServletRequest httpServletRequest = ((HttpServletConnection) ctx.getConnection()).getHttpServletRequest();

        String pathInfo = httpServletRequest.getPathInfo();
        String queryString = httpServletRequest.getQueryString();

        return pathInfo + "?" + queryString;
    }
}