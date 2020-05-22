@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/applicationContext.xml")
public class YourTest {

    @Transactional
    public void someTest() {
    }
}