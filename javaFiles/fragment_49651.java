@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
   @RunWith(SpringJUnit4ClassRunner.class)
   public class AutowiredTest {
    @Autowired
    private ActionBeans localBeans;

    // Added here
    @Autowired
    private TestClazz t;

    @Test
    public void autoWiredLocallyTest(){
        //pre-test
        Assert.assertNotNull(localBeans);
    }

    @Test
    public void autoWireAtClassTest(){
        //TestClazz t = new TestClazz(); COMMENTED OUT
        boolean isAutoWiredFromClass =  t.isAutowired();
        Assert.assertTrue(isAutoWiredFromClass);
    }
   }