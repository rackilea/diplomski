public class LoginController {
  public interface Factory {
    LoginController create(LoginDialog dlg);
  }

  @Inject public LoginController(
      EventBus eventBus,
      MyPublisherService publisherService,
      @Assisted LoginDialog dlg) { /* ... */ }
}

// in your module
install(new FactoryModuleBuilder().build(LoginController.Factory.class));