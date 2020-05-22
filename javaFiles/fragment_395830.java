public class TinyTomcat7Embedded {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File baseDir = new File("tomcat");
        tomcat.setBaseDir(baseDir.getAbsolutePath());

        File applicationDir = new File(baseDir + "/webapps", "/ROOT");
        if (!applicationDir.exists()) {
            applicationDir.mkdirs();
        }

        try {
            Context appContext = tomcat.addWebapp("/", "ROOT");

            // A Jetty AbstractHandler is an HttpServlet here:
            Tomcat.addServlet(appContext, "helloWorldServlet", new HttpServlet() {

                @Override
                protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    response.setContentType("text/html;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println("<h1>Hello World</h1>");
                }
            });
            appContext.addServletMapping("/helloworld", "helloWorldServlet");

            tomcat.start();
            System.out.println("Tomcat server: http://" + tomcat.getHost().getName() + ":" + 8080 + "/");
            tomcat.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}