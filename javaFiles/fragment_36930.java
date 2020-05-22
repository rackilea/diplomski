@Bean
public SessionFactory sessionFactory() {
 return new LocalSessionFactoryBuilder(datasource())
   .addAnnotatedClasses(Account.class, Contact.class)
   .addProperties(hibernateProperties())
   .buildSessionFactory();
}