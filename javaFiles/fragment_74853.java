@Override
protected Class<?>[] getRootConfigClasses() {
return new Class<?>[] { CoreConfig.class, LibConfig.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
return new Class<?>[] { WebConfig.class};
}