import java.lang.reflect.Field;
import javax.validation.constraints.NotNull;
import org.junit.Test;
import org.springframework.util.Assert;

public class TestHasAnnotatedField {
    @Test
    public void testHasFieldsWithAnnotation() throws SecurityException, NoSuchFieldException {
        Class<?>[] classesToVerify = new Class[] {MyClass1.class, MyClass2.class};
        for (Class<?> clazz : classesToVerify) {
            Field field = clazz.getDeclaredField("something");
            Assert.notNull(field.getAnnotation(NotNull.class));
        }
    }
    static class MyClass1 { @NotNull String something; }
    static class MyClass2 { @NotNull String something; }
}