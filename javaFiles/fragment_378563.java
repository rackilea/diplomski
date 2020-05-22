public class YourApplication {

  public static void main(String[] args) {
    // Only three lines exist outside the object graph.
    Injector injector = Guice.createInjector(new YourModule1(), new YourModule2());
    YourApplication app = injector.getInstance(YourApplication.class);
    app.run();
  }

  @Inject Provider<YourDep1> depProvider1;
  @Inject YourDep2 dep2;

  public void run() {
    // Here you have access to every @Inject field.
  }
}