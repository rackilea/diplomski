public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Autowired protected ElasticsearchTemplate elasticsearchTemplate;

    public List<User> findFuzzyByLastNameAndFirstName(String firstName, String lastName) {
        Criteria c = new Criteria("firstName").fuzzy(firstName).and(new Criteria("lastName").fuzzy(lastName));
        return elasticsearchTemplate.queryForList(new CriteriaQuery(c), CandidateEntity.class);
    }
}