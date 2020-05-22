@Override
protected AppDescriptor configure() {
    return new WebAppDescriptor.Builder("com.yourproject.blah")
            .initParam("com.sun.jersey.spi.container.ContainerRequestFilters", 
                "com.sun.jersey.api.container.filter.PostReplaceFilter")
            .servletClass(SpringServlet.class)
            .build();
}