public class WebInit implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "spring-mvc";
    private static final String DISPATCHER_SERVLET_MAPPING = "/";

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {       

        //If you want to use the XML configuration, comment the following two lines out.
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(CoreConfig.class);
        appContext.setDisplayName("removed customer name");       

        //If you want to use the XML configuration, uncomment the following lines.
        //XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        //rootContext.setConfigLocation("classpath:mvc-servlet.xml");

        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(ServletConfig.class);

        ServletRegistration.Dynamic springmvc =
                servletContext.addServlet(DISPATCHER_SERVLET_NAME,
                          new DispatcherServlet(mvcContext));
        springmvc.setLoadOnStartup(1);
        springmvc.addMapping(DISPATCHER_SERVLET_MAPPING);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

        FilterRegistration.Dynamic security = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        security.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

        servletContext.addListener(new ContextLoaderListener(appContext));
    }