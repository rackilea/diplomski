SimpleClientHttpRequestFactory factory = new   SimpleClientHttpRequestFactory();
    InetSocketAddress address = new InetSocketAddress(host,portNr);
    Proxy proxy = new Proxy(Proxy.Type.HTTP,address);
    factory.setProxy(proxy);

    restTemplate.setRequestFactory(factory);