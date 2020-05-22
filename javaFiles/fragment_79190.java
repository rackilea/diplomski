public class DBSession {

    public SqlSession openSession() throws IOException {
        SqlSessionFactory sessionFactory = getFactory();
        return sessionFactory.openSession();
    }

    private SqlSessionFactory getFactory() throws IOException {
        String resource = "mybatis/conf/ibatis.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sessionFactory;
    }
}