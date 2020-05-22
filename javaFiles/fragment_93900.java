@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-test.xml"})
@Transactional
public class MyTest {

    @Resource(name="myService")
    public IMyService myService;