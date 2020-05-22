@Component("achResponseDMDao")
public class AchResponseDMDaoImpl implements IBasicDao<AchResponseDM>{
    @Autowired
    MongoFactory mongoFactory;

@Override
public AchResponseDM findByResponseCode( String responseCode){
    Query query = new Query(Criteria.where("responseCode").is(responseCode));        
    List<AchResponseDM> listOfResponses = mongoTemplate(mongoFactory).find(query, AchResponseDM.class);
    return (listOfResponses!=null && !listOfResponses.isEmpty())?listOfResponses.get(0):defaultNonNullResponse();
}
...
}