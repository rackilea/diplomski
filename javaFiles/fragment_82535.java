@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/config/mvc-config.xml", 
                "file:src/main/webapp/WEB-INF/config/application-context.xml"})
public class AdvertORMServiceTest {