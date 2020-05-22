private GuiceBundle<MyConfiguration> guiceBundle;

@Override
public void initialize(Bootstrap<MyConfiguration> bootstrap) {

  guiceBundle = GuiceBundle.<MyConfiguration>newBuilder()
    .addModule(new MyModule())
    .setConfigClass(MyConfiguration.class)
    .build(Stage.DEVELOPMENT);

  bootstrap.addBundle(guiceBundle);
}