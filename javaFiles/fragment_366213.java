public class BaseTestClass {

    public void setUp() {
        System.out.println("Base Test Class");
    }
}


public class InheritsFromBase extends BaseTestClass {

    @Override
    @BeforeEach
    public void setUp() {
        System.out.println("I inherit from base");
        super.setUp();
    }
}