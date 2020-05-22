public class Transactor {

    public static void delete(Car o) {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(o);
            transaction.commit();
        } catch (HibernateException ex) {
            System.out.println("Error deleting car: " + ex);
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
    }


    public static List<Car> findAll() {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException ex) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        List<Car> carsList = new ArrayList<>();
        try {
            carsList = session.createQuery("from Car").list();
        } catch (HibernateException he) {
            System.out.println("Error getting cars: " + he);
            he.printStackTrace();
        } finally {
            if (session.isOpen()){
                session.close();
            }
        }
        return carsList;
    }
}