import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TimeMeasurer {
    public static void gettimes(Class c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        List<Method> methods=Arrays.asList(c.getMethods());
        for(Method m:methods)
        {
            List<Annotation> ans= Arrays.asList(m.getAnnotations());
            List<Class> classes = new ArrayList<>();
            for(Annotation a:ans)
            {
                classes.add(a.getClass());
            }
            //if(classes.contains(Deprecated.class))

            {
                if (m.getParameterCount()!=0)
                {
                    System.err.println("The method "+m.getName()+" could not be executed as it has parameters. Use a method with example values instead!");
                }
                else
                {
                    System.out.println("Executing Method: "+m.getName());
                    long stamp = System.nanoTime();
                    Object result=m.invoke(c);
                    long timeconsumed=System.nanoTime()-stamp;
                    System.out.println("Result of Method: "+result);

                    System.out.println("Time needed: "+timeconsumed);
                }
            }
        }
    }
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        gettimes(EndloseFormel.class);
    }
}