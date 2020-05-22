@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/spring/applicationContext.xml",
        "file:web/WEB-INF/spring/services.xml"})
@Transactional
public class DoNotRollBackTest {
    @Autowired FakeService fakeService;

    @Test
    @Rollback(false)
    public void testRunXFireException() {
        fakeService.doSomeTransactionalStuff();
    }
}