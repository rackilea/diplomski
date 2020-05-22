public @Bean HttpInvokerProxyFactoryBean httpInvokerProxy() {
    HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
    proxy.setServiceInterface(AccountService.class);
    proxy.setServiceUrl("http://remotehost:8080/remoting/AccountService");
    return proxy;
}