public class TestModule extends ProductionModule {
   @Override
   protected MyObject delegateProvide(Dependency dependency) {
       return new MyObjectSpy(super.delegateProvide(dependency));
   }
}