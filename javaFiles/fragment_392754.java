public static Logger log = LoggerFactory.getLogger(MyCaptionLabsApplication.class);

    @Bean
    public ItemQueryRqSoapImpl itemQueryRqSoapImpl() {
        return new ItemQueryRqSoapImpl();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyCaptionLabsApplication.class);
    }

    public static void main(String[] args) {
        log.debug("running my Application");        
        ApplicationContext applicationContext = SpringApplication.run(MyCaptionLabsApplication.class, args);
        ItemQueryRqSoapImpl itemQueryRqSoapImpl = applicationContext.getBean(ItemQueryRqSoapImpl.class);

        Endpoint.publish("http://localhost:8080/QBwebService",
            itemQueryRqSoapImpl);

}