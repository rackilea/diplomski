@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/context.xml"})
public class UserPushDAOImplTest {

    @Resource(name="userPushDAO")
    private UserPushDAO userPushDAO;

    @Test
    @Transactional
    public void test() {
         userPushDAO.deleteById("id");
    }
}