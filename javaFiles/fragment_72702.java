@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class, JpaConfiguration.class})
public class SomeEntityDaoIntegrationTests {

    @Autowired
    private SomeEntityDao someEntityDao;

    @Test
    public void testSave() {

        SomeEntity someEntity = new SomeEntity();
        someEntity.setId("foo");
        someEntity.setSomeField("bar");

        this.someEntityDao.save(someEntity);
    }
}