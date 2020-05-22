@ContextConfiguration(classes = TestConfig)
@RunWith(SpringRunner.class)
class OrganizationServiceTest {

    @Autowired
    OrganizationService organizationService

     @Test
    void testRegister() {
        def org = new Organization()
        //...
        organizationService.register(org)
        // ...
    }