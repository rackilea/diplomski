public class MyService {

    public void doSomething() {
        getSessionFactory().beginTransaction();

        // A POJO doing some operation

        // Other POJO doing other operation

        // Another POJO doing another operation

        getSessionFactory().getTransaction().commit();
    }

}