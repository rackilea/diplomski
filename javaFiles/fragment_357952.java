@Autowired
private EntityManagerFactory emf;

public void foo(){
EntityManager em = emf.createEntityManager();
Session session = em.unwrap(Session.class);
LobCreator lob = getLobCreator(session);
...
}