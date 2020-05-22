public void runJsp() {
    JspC jspc = new JspC();
    jspc.setUriroot("/tmp/app");
    jspc.setOutputDir("/tmp/dest");
    jspc.setJspFiles("newjsp.jsp");
    jspc.setCompile(true);
    try {
        jspc.execute();
        Class cls = Class.forName("org.apache.jsp.newjsp_jsp");
        Servlet s = (Servlet) cls.newInstance();
        MyRequest req = new MyRequest();
        MyResponse resp = new MyResponse();

        s.init(getServletConfig());
        s.service(req, resp);
        s.destroy();
        System.out.println(resp.getSw().toString());
    } catch (JasperException ex) {
        throw new RuntimeException(ex);
    } catch (ClassNotFoundException ex) {
        throw new RuntimeException(ex);
    } catch (InstantiationException ex) {
        throw new RuntimeException(ex);
    } catch (IllegalAccessException ex) {
        throw new RuntimeException(ex);
    } catch (ServletException ex) {
        throw new RuntimeException(ex);
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
}