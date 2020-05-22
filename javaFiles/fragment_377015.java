import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDatabaseDaoImpl implements CustomerDatabaseDao {

    @Autowired
    private SessionFactory session;

    @Transactional
    public void addCus(Customer c) {
        this.session.getCurrentSession().save(c);
    }
}