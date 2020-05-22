public class MyModule {
    @Override
    public void configure() {
        bind(MyDao.class).to(MyDaoImpl.class).in(Singleton.class);
        bind(MyService.class).in(Singleton.class);
    }
}