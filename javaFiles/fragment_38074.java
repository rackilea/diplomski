@Autowired
    private Bus bus;

    @Bean("queryQuotaWebService")
    public Endpoint queryQuotaEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new QueryQuotaWebServiceImpl());
        endpoint.publish("/QueryQuotaWebService");
        return endpoint;
    }