@Autowired
MongoRepository mongoRepository;
@Autowired
CrudRepository crudRepository;

@Value("isMongo")
boolean isMongo;

private Repository actualRepository;

 @PostConstruct
  public void init() {
    actualRepository = isMongo ? mongoRepository : crudRepository;
  }