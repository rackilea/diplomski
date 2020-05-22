public static abstract class IDao {

    @Inject
    private DummyEntityManager em;

    protected abstract String getData();

    public void close() {
        em.close();
    }

    protected DummyEntityManager getEntityManager() {
        return em;
    }
}