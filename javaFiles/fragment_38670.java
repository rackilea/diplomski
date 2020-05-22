@Transactional
public static void storeTestData(EntityManager em, String name, String value) {
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();

        TestDataEntity entity = new TestDataEntity();
        entity.setName(name);
        entity.setValue(value);

        em.persist(entity);

        transaction.commit();
    } catch (RuntimeException re) {
        if (transaction != null && transaction.isActive())  {
            transaction.rollback();
        }

        throw re;
    }