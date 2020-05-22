public class UnitsDaoImpl implements UnitsDao {

    private Session session;

    public UnitsDaoImpl(final Session session) {
        this.session = session;
    }

    @Override
    public List<Units> fetchAll() {

        return session.createQuery("FROM Units").list();
    }
    // Other methods...
}