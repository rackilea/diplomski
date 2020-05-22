JpaTransactionManager tm = context.getBean(JpaTransactionManager.class);
EntityManagerFactory emf = tm.getEntityManagerFactory();

TransactionTemplate template = new TransactionTemplate(tm);
template.execute(status -> {
    EntityManager em = EntityManagerFactoryUtils.getTransactionalEntityManager(emf);
    Department department = new Department();
    department.setId(15);
    department.setName("Engineering");
    em.persist(department);
    return department;
});