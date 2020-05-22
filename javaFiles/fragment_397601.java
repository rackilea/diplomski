package demo;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void accessPrivateMethods() throws Throwable {
        Class<?> klassEmployee = Class.forName("demo.Employee");

        Class<?> EmployeeInnerKlass = klassEmployee.getDeclaredClasses()[0];

        //To get the "EmployeeInnerKlass" declared class in the Employee Class
        Class<?> InnerKlass = Class.forName("demo.InnerKlass");

        Method method = EmployeeInnerKlass.getDeclaredMethod("getText", null);
        method.setAccessible(true);
        method.invoke(null, null);

        Method method2 = InnerKlass.getDeclaredMethod("getText", null);
        method2.setAccessible(true);
        method2.invoke(null, null);
    }
}