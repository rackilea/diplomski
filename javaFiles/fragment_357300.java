@Bean
@Scope("prototype")
@InjectableInto("singleton")
MyBean getMyBean(){
  //...
}