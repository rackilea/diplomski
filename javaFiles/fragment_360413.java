@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @MockBean
    AmazonCredentials amazonCredentials;

    @Test
    public void contextLoads() {
    }
}