@Configuration
@ComponentScan(basePackages = {"com.foobarpkg"})
class Configuration { 
 @Bean
  IFoo foo() {
    return this.isZ() ? new Fooz() : new Foo ();
  }
  // foobar bean is no longer declared here
}