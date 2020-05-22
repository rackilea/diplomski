@Autowired
SessionFactory sessionFactory;
Session session;

@PostConstruct
void init() {
    this.session = sessionFactory.getCurrentSession();
}