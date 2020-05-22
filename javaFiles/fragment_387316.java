@Bean(name = "hiberTemp")
    public HibernateTemplate m14() {
      System.out.println("hibernate template started...");
      HibernateTemplate ht = new HibernateTemplate();
      MyConfig conf = new MyConfig();
      LocalSessionFactoryBean lsf = conf.m12();
      SessionFactory sf = 1sf.getObject();
      ht.setSessionFactory(sf);
      System.out.println("hibernate template end...");
      return ht;
}