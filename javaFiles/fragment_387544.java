class MyService {
    ...
    private final Dao dao;

    @Inject
    public MyService(Dao dao) {
        this.dao = dao;
    } 
    ...
}