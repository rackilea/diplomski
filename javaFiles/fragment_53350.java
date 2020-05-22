TestJobRepositoryCustomImpl.java

@Transactional
public class TestJobRepositoryCustomImpl implements TestJobRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public int upsert(UUID id, Parameters parameters) {
        final String parametersAsString = objectMapper.writer().writeValueAsString(parameters);
        final Query query = entityManager.createNativeQuery("INSERT INTO testjob (id, parameters) VALUES(:id, cast(:parameters as jsonb))");
        query.setParameter("id", id);
        query.setParameter("parameters", parametersAsString);
        return query.executeUpdate();
    }

}