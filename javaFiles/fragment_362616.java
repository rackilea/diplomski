@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfiguration.class)
public abstract class AbstractTransactionResourceTest<T> {

    @Autowired
    private ITransactionResource transactionResource;

    @Autowired
    private MongoOperations mongoOperations;

    @Before
    public void setUpDb() {
        String entitiesStr = FileUtils.getFileAsString(entityName() + ".js");
        List<T> entities = new ObjectMapper().readValue(entitiesStr, new TypeReference<List<T>>() {});
        entities.forEach((t) -> {            
            mongoOperations.save(t, entityName());
        }); 
    }    

    protected abstract String entityName();
}