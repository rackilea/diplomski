AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

context.register(SomeAnnotatedClass.class);
context.register(AnotherAnnotatedClass.class);

// more configuration ...

context.refresh();

// this is the servlet that we need to add to Tomcat
DispatcherServlet servlet = new DispatcherServlet(context);