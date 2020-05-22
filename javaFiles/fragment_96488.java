interface LoginService {
  interface Factory {
    LoginService create(NetConnection connection);
  }
  boolean login(String username, String password);
}

class SimpleLoginService implements LoginService {
  @Inject SimpleLoginService(@Assisted NetConnection connection) { /* ... */ }
}

class SecuredLoginService implements LoginService {
  @Inject SecuredLoginService(
      EncryptionService encryptionService,
      @Assisted NetConnection connection) { /* ... */ }
}

// in your module: implements LoginService.Factory
install(new FactoryModuleBuilder()
    .implement(LoginService.class, SimpleLoginService.class)
    .build(LoginService.Factory.class));
// this one implements @Secured LoginService.Factory
install(new FactoryModuleBuilder()
    .implement(LoginService.class, SecuredLoginService.class)
    .build(Key.get(LoginService.Factory.class, Secured.class));