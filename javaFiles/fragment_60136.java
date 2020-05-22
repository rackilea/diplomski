@PersistenceUnit(unitName = "test-api")
EntityManagerFactory emf;

@Transactional
public Department addDepartment(String name) {
   EntityManager em = EntityManagerFactoryUtils.getTransactionalEntityManager(emf);
   Department department = new Department();
   department.setName(name);
   em.persist(department);
   return department;
});