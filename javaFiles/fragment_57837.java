import java.io.IOException;
            import javax.faces.webapp.FacesServlet;
            import javax.inject.Inject;
            import javax.inject.Singleton;
            import javax.servlet.Servlet;
            import javax.servlet.ServletConfig;
            import javax.servlet.ServletException;
            import javax.servlet.ServletRequest;
            import javax.servlet.ServletResponse;
            import javax.servlet.http.HttpServlet;
            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;

            @Singleton
            public class FacesHttpServlet extends HttpServlet {

                private static final long serialVersionUID = 1L;

                private final Servlet facesServlet;

                @Inject
                public FacesHttpServlet(FacesServlet facesServlet) {
                    this.facesServlet = facesServlet;
                }

                @Override
                public void init(ServletConfig config) throws ServletException {
                    this.facesServlet.init(config);
                }

                @Override
                public ServletConfig getServletConfig() {
                    return this.facesServlet.getServletConfig();
                }

                @Override
                public String getServletInfo() {
                    return this.facesServlet.getServletInfo();
                }

                @Override
                public void destroy() {
                    super.destroy();
                    this.facesServlet.destroy();
                }

                @Override
                public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
                    HttpServletRequest httpReq = (HttpServletRequest) req;
                    String reqUrl = httpReq.getRequestURL().toString();
                    // A hack to redirect the index page. It's been throwing an error if the
                    // "/index.[xhtml|jsf]" is not explicitly specified in the request URL.
                    if(reqUrl.toLowerCase().endsWith("index.xhtml")) {
                        ((HttpServletResponse) resp).sendRedirect(reqUrl.replace("index.xhtml", "index.jsf"));
                    } else {
                        this.facesServlet.service(req, resp);
                    }
                }
            }