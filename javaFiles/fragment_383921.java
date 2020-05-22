@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql","classpath:data.sql"})
public class DataDaoTest {
    ...

    @Test
    public void testRetrieval() throws Exception {
        ...
    }
}