public class Controller {

    private EntityManagerFactory emf;

    public void doSomeUnitOfWork(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CrudDao dao = new CrudDao(em);

        Entity entity = dao.get(id);
        entity.setName("James");
        dao.save(entity);

        em.getTransaction.commit();
        em.close();
    }

}