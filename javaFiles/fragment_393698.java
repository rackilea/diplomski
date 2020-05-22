@RunWith(Parameterized.class)
public class Test {

    private static ExpensiveObjectCacher cacher; //instance which caches parameter instance
    private ExpensiveObject myObject;

    public Test(String value) {
        this.myObject = cacher.get(value); 
    }

    @BeforeClass
    public static void setUpBeforeClass(){
        cacher = new ExpensiveObjectCacher();
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "parameter1" },
            { "parameter2" },
                };
        return Arrays.asList(data);
    }

    @org.junit.Test
    public void test1(){

    }

    @org.junit.Test
    public void test2(){

    }
}

//caching for test cases. 
class ExpensiveObjectCacher{
    private Map<String, ExpensiveObject> map = new ConcurrentHashMap<String, ExpensiveObject>();

    ExpensiveObject get(String value){
        ExpensiveObject instance = map.get(value);

        if(instance == null){
            instance = new ExpensiveObject(value);
            map.put(value, instance);
        }

        return instance;
    }
}

class ExpensiveObject{
    public ExpensiveObject(String value) {
        System.out.println("Instance created: " + value);
    }
}