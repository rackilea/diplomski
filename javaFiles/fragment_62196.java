public abstract class AbstractSampleServlet extends HttpServlet {

  protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    sampleMethodName(request, response);
  }

  protected abstract void sampleMethodName(HttpServletRequest request, HttpServletResponse response) throws IOException;

}