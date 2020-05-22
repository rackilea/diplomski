@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource("classpath:/application.properties")
public class EntApiUtilTest

 @Autowire
 private EntApiUtil entApiUtil

   @Test
    public void validateAddress_statusVO_not_null(){
///..address etc
        statusVO =  entApiUtil.validateAddress(address);
        assertNotNull(statusVO);
    }

}