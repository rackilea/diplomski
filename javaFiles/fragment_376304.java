@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath:vdb-servlet.xml", "classpath:vdb-data.xml"})
public class ActivityDAOTest
{
    @Autowired
    private ActivityDAO activityDAO;

    @Test
    public void testConstructor(){
        activityDAO.methodTotest();
    }
}