@Autowired
   @Qualifier("session2")
   SessionFactory sessionFactory;

   @GetMapping(value = "/test2")
   @Transactional("tx2")
   public void test2() {
    List<String> cities = sessionFactory.getCurrentSession().createSQLQuery("select city from address")
            .list();
    System.out.println("------------ citties ------------ " + cities);
}