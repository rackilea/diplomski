@Autowired
 @Qualifier("germanGreetingServiceImpl")
 private GreetingService germanGreetingService;

 @Autowired
 @Qualifier("englishGreetingServiceImpl")
 private GreetingService englishGreetingService;

 @PostConstruct
 public void init () {
        greetingBeanMap = new HashMap<>();
        greetingBeanMap.put("en", englishGreetingService);
        greetingBeanMap.put("de", germanGreetingService); 
 }