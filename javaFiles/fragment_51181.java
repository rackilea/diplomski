@PersistenceContext(unitName = "dataSourcePU")
EntityManager entityManager;

@Autowired
@Qualifier("enduserEntityManagerFactory")
EntityManagerFactory endUserEntityManagerFactory;

EntityManager endUserEntityManager;

@PostConstruct
public void init() {
    endUserEntityManager = endUserEntityManagerFactory.createEntityManager();
}