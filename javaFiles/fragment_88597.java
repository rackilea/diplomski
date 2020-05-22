@ContextConfiguration(classes={WebConfig.class})
@WebAppConfiguration("src/main/java")
public class AopConfigTest extends AbstractJUnit4SpringContextTests {

     @Autowired
     private TestAOP testAop;

     @Autowired
     private TestAOPClient client;

     @Test
     public void assertTestConfigIsActive() {
        client.relayMessage("hello");
        assertThat(((TestAOP)applicationContext.getBean("testAop")).getMessage(), 
            equalTo("hello"));
    }

}