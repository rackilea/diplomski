ConfigurationContext axisContext;
try {
    axisContext = ConfigurationContextFactory.createDefaultConfigurationContext();
} catch (Exception e) {
    throw new AxisFault(e.getMessage());
}
axisContext.setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);
stub = new MyStub(axisContext, url);