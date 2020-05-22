class MainDependency{
  @Inject
  public MainDependency(@Named("myConst") int myConst){
    //...
  }
}

class Module extends AbstractModule{
  public void configure(){
    bindConstant().annotatedWith(Names.named("myConst").to(MY_CONSTANT);
  }
}