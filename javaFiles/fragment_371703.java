import org.junit.Test;
import static mockit.Deencapsulation.*;
import mockit.*;

public class TestAClass
{
    public static class ClassToTest 
    {
        public void methodToTest()
        {
            boolean returnValue = methodToMock(0);
            System.out.println("methodToMock returned " + returnValue);
        }

        private boolean methodToMock(int value) { return true; }
    }

    @Tested ClassToTest classToTestInstance;

    @Test
    public void partiallyMockTestedClass() {
        new Expectations(classToTestInstance) {{
            invoke(classToTestInstance, "methodToMock", anyInt);
            result = false;
            times = 2;
        }};

        classToTestInstance.methodToTest();
        classToTestInstance.methodToTest();
        classToTestInstance.methodToTest();
    }
}