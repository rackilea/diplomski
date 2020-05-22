@Repository
public class ItemDAO extends BasicDAO<Item, ObjectId> implements IItemDAO{


    @Autowired
    public ItemDAO(MongoClient mongoClient, Morphia morphia,@Value("${mongo.mongoDB}") String mongoDB) {
        super(mongoClient, morphia, mongoDB);
    }
}