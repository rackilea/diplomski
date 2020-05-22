@SpringJUnitJupiterConfig(classes = {RepositoryTestConfig.class})
@MapperScan
@Rollback
@Transactional
public class TestClass {
    @Autowired
    private TestMapper testMapper;

    @BeforeEach
    void init() {
        User user = new User();
        testMapper.insert(user);    
    }

    @Nested
    @SpringJUnitJupiterConfig(classes = {RepositoryTestConfig.class})
    @MapperScan
    @Rollback
    @Transactional
    class WhenExistData {
        @Test
        public void test2() {
        }   
    }
}