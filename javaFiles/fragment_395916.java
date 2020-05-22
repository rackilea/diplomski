String[] configurationClasses =
{
    "org.eclipse.jetty.webapp.WebInfConfiguration",
    "org.eclipse.jetty.webapp.WebXmlConfiguration",
    "org.eclipse.jetty.webapp.MetaInfConfiguration",
    "org.eclipse.jetty.webapp.FragmentConfiguration",
    "org.eclipse.jetty.plus.webapp.EnvConfiguration",
    "org.eclipse.jetty.webapp.JettyWebXmlConfiguration"
};
WebAppContext webapp = new WebAppContext();
webapp.setConfigurationClasses(configurationClasses);
webapp.setDescriptor("/path/to/webapp/WEB-INF/web.xml");
webapp.setContextPath("/");
webapp.setResourceBase("/path/to/webapp");
webapp.setClassLoader(Thread.currentThread().getContextClassLoader());