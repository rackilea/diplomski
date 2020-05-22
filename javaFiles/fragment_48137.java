public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ArrayList<User> findbyCreatedAtBetween(Date from, Date to) {
        return mongoTemplate.find(
            Query.addCriteria(Criteria.where("createdAt").gte(from).lte(to));
    }
}