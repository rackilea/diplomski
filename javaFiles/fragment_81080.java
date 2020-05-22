public class TestInjectMocks {

    /**
     * Small interface that will be implemented by the wrapper classes
     * only used to get the main class
     */
    public interface TestConfig {
        SomeClass getSomeClass();
    }

    @Test
    public void dependencyShouldBeNotNull() {
        // This class will allow to get an instance of SomeClass 
        // with the field injected
        TestConfig obj = new TestConfig() {
            @Mock
            private SomeDependency<T> obj;
            @InjectMocks
            private SomeClass mainObj;

            @Override
            public SomeClass getSomeClass() {
                return mainObj;
            }
        };
        MockitoAnnotations.initMocks(obj);
        SomeClass mainObj = obj.getSomeClass();
        //here I need one value of SomeDependency obj
        assertEquals(2, mainObj.method());
    }

    @Test
    public void dependencyShouldBeNull() {
        // This class will allow to get an instance of SomeClass 
        // without the field injected
        TestConfig obj = new TestConfig(){
            @InjectMocks
            private SomeClass mainObj;
            @Override
            public SomeClass getSomeClass() {
                return mainObj;
            }
        };
        MockitoAnnotations.initMocks(obj);
        SomeClass mainObj = obj.getSomeClass();
        //here I need SomeDependency obj to be null
        assertEquals(1, mainObj.method());
    }
}