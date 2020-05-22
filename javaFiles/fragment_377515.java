@Autowired
    private Environment environment;

    @PostConstruct
    private void validateProperties() {

        environment.getProperty(key);
        .....
        ......
    }