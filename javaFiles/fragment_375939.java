@Bean
GreeterFactoryBean greeter() {
  GreeterFactoryBean factoryBean = new GreeterFactoryBean();
  factoryBean.set...
  return factoryBean;
}