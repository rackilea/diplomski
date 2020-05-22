@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void sqlInjections() throws Exception {
        User user = userMapper.getUser("admin'--");
        assertNull(user);
    }


@Mapper
public interface UserMapper {

    @Select("select * from user WHERE name =#{name}")
    @Results(value = {
             @Result(property = "name", column = "name"),
             @Result(property = "password", column = "password"),
             @Result(property = "encrypted", column = "encrypted"),
             @Result(property = "permission", column = "permission")
           })
    User getUser(@Param("name")String name);