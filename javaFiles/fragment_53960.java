public class MyTest {    
    private List<MySQLContainer> containers;

    @Before
    public void initContainers() {
        containers =  = Arrays.asList(new MySQLContainer("5.5"), new MySQLContainer("5.6"));
    }

    @Test
    public void myTest() {
        // Some test...    
    }
}