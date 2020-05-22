@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:META-INF/conf/spring/application-context.xml",
                        "classpath:META-INF/conf/spring/test-datasource-spring-config.xml" })
@TransactionConfiguration(transactionManager="txMgr", defaultRollback=false)
public class LevelDaoTest {

    @Resource( name="levelDao" )
    LevelDao levelDao;

    @Test
    public void shouldSaveNewLevels() {

        Level l = new Level();
        l.setName("aname");
        levelDao.save(l);
        // assert
    }

    @Test
    public void shouldUpdateExistingLevels() {

        Level l = new Level(); // or I would assume, you'd read this level back from DB, or set a proper ID, so the DAO will know to update it.. But that is besides the point
        l.setName("bname");
        levelDao.update(l);
        // assert
    }
}