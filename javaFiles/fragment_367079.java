public class Test {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        Adress adress = new Adress();
        adress.setLocality("New York");
        adress.setZipCode("55-5555");
        adress.setStreetNumber("55");

        employee.setFirstName("Andy");
        employee.setLastName("Cole");
        employee.setSalary(3333);

        employee.setAdress(adress);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}