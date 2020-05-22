import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
         Test testExample = new Test();
            testExample.testMethod("String1", 1, "String2");
    }

     public void testMethod(Object... inputs){
            InputManipulation test = new InputManipulation();
            for (Object input: inputs){

                Class<? extends Object> ownerClass = test.getClass();
                Class<? extends Object> inputClass = input.getClass();
                //Method method;    //not needed

                try {
                    ownerClass.getDeclaredMethod("add", inputClass).invoke(test, input);

                } catch (NoSuchMethodException | SecurityException | 
                        IllegalAccessException | IllegalArgumentException |
                        InvocationTargetException e) {

                    e.printStackTrace();
                }

            }

      }
}