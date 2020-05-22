class MyService{

    @Autowired
    private ApplicationContext applicationContext;      

    MyService self;

    @PostConstruct
    private void init() {
        self = applicationContext.getBean(MyService.class);
    }

    public Map<String, String> getSampleMethod1() {
        Map<String, String> map = self.getSampleMethod2();
        return map;
    }
}