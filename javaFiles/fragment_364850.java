Service s = Service.create(
        new URL("http://example.com/your_service?wsdl"),
        new QName("http://example.com/your_namespace", "YourServiceName"));
ServiceInterface yourService = s.getPort(
        new QName("http://example.com/your_namespace", "YourPortName"),
        ServiceInterface.class);