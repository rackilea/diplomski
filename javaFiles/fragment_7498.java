ServletContext servletContext = ...
Resource res = new ServletContextResource(servletContext,
  "/WEB-INF/businesscaliber-servlet.xml");
BeanFactory factory = new XmlBeanFactory(res);
if (factory != null && beanId != null) {
    obj = factory.getBean(beanId);
}