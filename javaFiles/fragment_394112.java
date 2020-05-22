public class MyResourceIT extends JerseyTest {
    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(MyResource.class);

        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(provideMyDaoMock()).to(MyDao.class);
            }

            private MyDao provideMyDaoMock() {
                MyDao myDaoMock = mock(MyDao.class);
                return myDaoMock;
            }
        });
        return resourceConfig;
    }
}