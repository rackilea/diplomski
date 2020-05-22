requestInjector.scopeRequest(InsertName.class, new AbstractModule()
{
  @Override
  protected void configure()
  {
    bind(String.class).annotatedWith(Names.named("name")).toInstance("John");
  }
})