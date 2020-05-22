private EntityManager manager;
private EntityManagerFactory emf  = null;

public PersonService() {
    if (manager == null){
        emf = Persistence.createEntityManagerFactory("myauto-unit");
        manager = emf.createEntityManager();
    }
}