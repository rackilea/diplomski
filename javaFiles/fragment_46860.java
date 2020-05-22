import java.lang.reflect.Method;

public class ReflectionCode {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, ClassNotFoundException {
        System.out.println(getInheritedClass(Parent.class.getName(),"overRiddenMethod"));
        System.out.println(getInheritedClass(Child.class.getName(),"overRiddenMethod"));
    }

    public static String getInheritedClass(String className, String method){
        Class clazz;
        try {
            clazz = Class.forName(className);

            if(clazz.getSuperclass() != null && clazz.getSuperclass().getMethod(method) != null)
            {
                return clazz.getSuperclass().getName();
            }
        }catch(Exception e){

        }
        return "none";
    }
}

class Parent  {

    public void overRiddenMethod(){

    }
}

class Child extends Parent {

    public void overRiddenMethod() {

    }
}