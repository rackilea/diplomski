public abstract class TestBase {
    private TheInterface unitToTest;

    protected abstract TheInterface getInterfaceImplementation();

    @Before
    public void setImplementation() {
         unitToTest = getInterfaceImplementation();
    }

    @Test
    public void test1 {
         //excercise and assert unitToTest
    }
}

public class ImplementationOneTest extends TestBase {
    protected TheInterface getInterfaceImplementation() {
        return new ImplementationOne();
    }
}

public class ImplementationTwoTest extends TestBase {
    protected TheInterface getInterfaceImplementation() {
        return new ImplementationTwo();
    }
}

etc.