@ContextConfiguration(value = "/myContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class) This is JUnit specific
@ActiveProfiles("dev")
public class TestCompareService {
    @Autowired(required = true)
    protected ITipService serveiTip;
    ....
}