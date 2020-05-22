public class FooBarTest {

    private static SessionFactory sessionFactory;

    @AfterClass
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    @BeforeClass
    public static void setupSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    @Test
    public void testBarFilter() {
        doInTransaction(new Command() {
            public void execute(Session session) {
                Foo foo = new Foo("foo");
                foo.addBar(new Bar("bar1"));
                foo.addBar(new Bar("bar2"));
                foo.addBar(new Bar("bar3"));
                session.save(foo);
            }
        });

        doInTransaction(new Command() {
            public void execute(Session session) {
                Bar bar = (Bar) session.createQuery(
                        "from Bar b where b.text = 'bar2'").
                        uniqueResult();
                bar.setDeleted(true);
                session.update(bar);
            }
        });

        doInTransaction(new Command() {
            public void execute(Session session) {
                session.enableFilter("deleted").
                        setParameter("deleted", Boolean.FALSE);
                Foo foo = (Foo) session.createQuery("from Foo").
                        uniqueResult();
                assertEquals(2, foo.getBars().size());
            }
        });
    }

    private void doInTransaction(Command command) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        command.execute(session);
        tx.commit();
        session.close();
    }
}

interface Command {
    public void execute(Session session);
}