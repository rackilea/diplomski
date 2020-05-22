@Service
class MyServiceImpl implements MyService{
    @Autowired
    private ExternalService externalService;
    private int value;

    MyServiceImpl () {

    }

    @PostConstruct
     public void initValue(){
        value = externalService.getValues();
     }
}