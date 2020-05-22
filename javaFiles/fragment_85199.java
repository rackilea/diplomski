@Bean
public ServletContextInitializer contextInitializer() {
    return new ServletContextInitializer() {

        @Override
        public void onStartup(ServletContext servletContext)
                throws ServletException {
                servletContext.setInitParameter("dummy.type","on-context-parameters");
        }
    };
}