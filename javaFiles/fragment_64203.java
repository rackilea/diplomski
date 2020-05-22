@RunWith(SpringRunner.class)
@JdbcTest
@ImportAutoConfiguration(JooqAutoConfiguration.class)
public class ConfigIT {

    @Autowired
    private DSLContext dSLContext;

    @Test
    public void dialectShouldBePickedUp() {
        assertThat(dSLContext.configuration().dialect(), is(SQLDialect.POSTGRES));
    }
}