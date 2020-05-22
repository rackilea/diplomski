@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager="txMgr", defaultRollback=false)
@Transactional
@WebAppConfiguration
@ComponentScan(basePackages ={ "com.project.surveyengine" }, excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void existsRole() throws Exception{
        Role role = roleService.getByName("ROLE_ADMIN");
        assertEquals("Correct test", Long.valueOf("5067160539889664"), role.getId());
    }

}