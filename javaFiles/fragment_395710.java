import java.lang.reflect.Method;
import org.junit.Assert;
import org.junit.Test;

public class SomeResourceHasAnnotatedField {

    @Test
    public void testHasMethodsWithAnnotation() throws SecurityException, NoSuchMethodException {
        Class resourceClass = SomeResource.class;
        Method[] methods = resourceClass.getDeclaredMethods();
        for (Method m : methods) {
            Assert.assertNotNull("Method :"+m.getName() + " does not have annotation AuthTokenRequired",m.getAnnotation(AuthTokenRequired.class));
            Assert.assertNotNull("Method :"+m.getName() + " does not have annotation ClientAppKeyRequired",m.getAnnotation(ClientAppKeyRequired.class));
        }
    }
}