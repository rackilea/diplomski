@Resource private UserTransaction mytx;
public static void main(String[] args)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("TestingJPAPU");

        EntityManager em = emFactory.createEntityManager();

        mytx.begin();
        Query query = em.createQuery("UPDATE Passengers p SET p.name = 'Robert' WHERE p.id = 2");

        query.executeUpdate();
        mytx.commit()
        em.close();
    }