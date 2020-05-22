SessionFactory sessionFactory;
Session session;
public BlacklistsDaoHibernate(@Autowired SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    this.session = sessionFactory.getCurrentSession();
}