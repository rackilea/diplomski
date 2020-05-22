public class JRubyServlet extends HttpServlet {

    private static final long serialVersionUID = -6913887886084787803L;
    private Ruby ruby;
    private Servlet rubyServlet;

  @Override public void init(ServletConfig config) throws ServletException {
      super.init(config);
      // Add location of the script to load path
      ruby = JavaEmbedUtils.initialize(asList("src/main/ruby"));

      // Instantiate ruby servlet, and store it into instance variable rubyServlet
      rubyServlet = (Servlet)JavaEmbedUtils.rubyToJava(ruby.evalScriptlet("require 'ruby_servlet'; RubyServlet.new"));
      rubyServlet.init(config);
  }

  @Override public void destroy() {
      JavaEmbedUtils.terminate(ruby);
      super.destroy();
  }

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

      // Call JRuby servlet's service method!
      rubyServlet.service(req, res);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      doGet(req, res);
  }