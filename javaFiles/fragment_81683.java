public static class DummyEntityManagerFactory 
        extends AbstractContainerRequestValueFactory<DummyEntityManager> {

    @Override
    public DummyEntityManager provide() {
        ContainerRequest request = getContainerRequest();
        // get some condition for EntityManager
        return new DummyEntityManager();
    }
}