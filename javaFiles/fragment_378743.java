interface MainDependencyFactory{
  MainDependency create(int myConst);
}

class MainDependency{
  @Inject
  public MainDependency(@Assisted int myConst){
    //..
  }
}

class Module extends AbstractModule{
  public void configure(){
    bind(MainDependencyFactory.class).toProvider(
      FactoryProvider.newFactory(MainDependencyFactory.class, MainDependency.class));
  }
}

//to use the above, instantiate your factory (or inject it somewhere)
MainDependencyFactory f = injector.getInstance(MainDependencyFactory.class);
//Then you can create MainDependency with any value
MainDependency md = f.create(MY_CONSTANT);