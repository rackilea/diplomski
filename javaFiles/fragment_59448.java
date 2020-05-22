package mycode;

import java.io.IOException;

import javax.servlet.*;

/**
 * Allows you to enforce a particular character encoding on incoming requests.
 * @author Robert J. Walker
 */
public class CharacterEncodingFilter implements Filter {
    private static final String ENCODINGPARAM = "encoding";

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter(ENCODINGPARAM);

        if (encoding != null) {
            encoding = encoding.trim();
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void destroy() {
        // do nothing
    }
}