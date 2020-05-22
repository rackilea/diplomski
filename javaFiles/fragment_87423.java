@Configuration
class Configuration {
  @Bean
  IFoo foo() {
    return this.isZ() ? new Fooz() : new Foo ();
  }
  @Bean
  IFoobar foobar(IFoo foo) { // IFoo bean declared above will be injected here by Spring
    return this.isZ() ? new Foobarz(foo) : new Foobar(foo);
  }
}