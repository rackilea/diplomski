@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@Transactional()
public class Test {

    @Autowired
    MyDao dao;

    @org.junit.Test
    @Rollback(false)
    public void testSomething() throws Exception {
        MyEntity e = new MyEntity();
        dao.create(e);
    }
}