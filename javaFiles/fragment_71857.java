public class MyServlet extends HttpServlet {

  private ThreadLocal<ScriptEngine> engineHolder;

  @Override
  public void init() throws ServletException {
    engineHolder = new ThreadLocal<ScriptEngine>() {
      @Override
      protected ScriptEngine initialValue() {
        return new ScriptEngineManager().getEngineByName("nashorn");
      }
    };
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    try (PrintWriter writer = res.getWriter()) {
      ScriptContext newContext = new SimpleScriptContext();
      newContext.setBindings(engineHolder.get().createBindings(), ScriptContext.ENGINE_SCOPE);
      Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
      engineScope.put("writer", writer);
      Object value = engineHolder.get().eval("writer.print('Hello, World!');", engineScope);
      writer.close();
    } catch (IOException | ScriptException ex) {
      Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}