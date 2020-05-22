@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class MyEntityDAOTest {

    @Autowired
    private MyEntityDAO myEntityDAO;

    @Test(expected = ConstraintViolationException.class)
    public void nullSizeNotAllowedTest() throws Exception {
        MyEntity myEntity = new MyEntity();
        myEntity.setId("testId");
        myEntity.setSize(null);
        myEntityDAO.save(myEntity);
    }
}