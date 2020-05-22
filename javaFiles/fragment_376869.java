/** Module that provides LoginService */
public class LoginServiceModule extends AbstractModule {
  @Override 
  protected void configure() {
    requireBinding(UserDao.class);
  }

  @Provides
  LoginService provideLoginService(UserDao dao) {
    ...
  }
}

@RunWith(JMock.class)
public class LoginServiceModuleTest {
  private final Mockery context = new Mockery();

  @Test
  public void testModule() {
    Injector injector = Guice.createInjector(
        new LoginServiceModule(), new ModuleDeps());

    // next line will throw an exception if dependencies missing
    injector.getProvider(LoginService.class);
  }

  private class ModuleDeps extends AbstractModule {
    private final UserDao fakeUserDao;

    public ModuleDeps() {
      fakeUserDao = context.mock(UserDao.class);
    }

    @Override 
    protected void configure() {}

    @Provides
    Server provideUserDao() {
      return fakeUserDao;
    }
  }
}