public static path.to.HibernateUtil.getSessionFactory;

public class AccountService {

    public void withdraw(Integer accountNumber, BigDecimal amount) throws Exception {
        /**
          * Here you set up Transaction boundaries
          */
        getSessionFactory().getCurrentSession().beginTransaction();

        // Some actions goes here

        getSessionFactory().getCurrentSession().getTransaction().commit();
    }

}