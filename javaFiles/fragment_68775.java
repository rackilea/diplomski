Service = new Service();

    Port = Service.getPort();

    ((BindingProvider) Port).getRequestContext().put(
            BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
            "http://localhost:8080/service");
    ((BindingProvider) Port).getRequestContext().put(
            BindingProviderProperties.CONNECT_TIMEOUT,
            30);
    ((BindingProvider) Port).getRequestContext().put(
            BindingProviderProperties.REQUEST_TIMEOUT,
            30);