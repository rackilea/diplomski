@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ATest {
    @Autowired
    TempFactory tempFactory;

    @Test
    public void test() {
        OtherClass otherClass = (OtherClass) tempFactory.getImpletationMap().get(OtherClass.class);
        UserRepository userRepository = otherClass.getUserRepository();
        Assert.assertNotNull(userRepository);
    }

}