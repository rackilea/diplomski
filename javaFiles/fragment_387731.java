@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MyAppTests.class})
@ActiveProfiles("dev")
public class AbstractTest {

    protected Logger LOGGER = Logger.getLogger(this.getClass());
}