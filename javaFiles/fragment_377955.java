public class Services {
    protected SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory value) {
        sessionFactory = value;
    }

    public List foo() {
       Query query = sessionFactory.getCurrentSession().createQuery("....");
       ...
    }
}