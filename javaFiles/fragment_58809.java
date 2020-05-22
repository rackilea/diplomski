package test.tmp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class StaticChecker
{
    public static void main(String[] args)
    {
        for(Class c : new Class[]{StaticChecker.class, ClassWithStatics.class, ClassWithoutStatics.class})
        {
            System.out.println("For " + c + "...");

            boolean hasStatic = hasStaticMembers(c);
            System.out.println("\tIt contains static members: " + hasStatic);

            if(hasStatic)
            {
                System.out.println("\tThe static members are:");
                for(String s : checkStaticMembers(c))
                    System.out.println("\t\t" + s);
            }
        }
    }

    public static boolean hasStaticMembers(Class c)
    {
        return checkStaticMembers(c).size() > 0;
    }

    public static List<String> checkStaticMembers(Class c)
    {
        List<String> staticMemberNames = new ArrayList<String>();

        for(Field field : c.getDeclaredFields())
            if(Modifier.isStatic(field.getModifiers()))
                staticMemberNames.add(field.toString());

        for(Method method : c.getDeclaredMethods())
            if(Modifier.isStatic(method.getModifiers()))
                staticMemberNames.add(method.toString());

        return staticMemberNames;
    }
}

class ClassWithStatics
{
    public static int N = 3;
    private static String S = "?";

    private int n;

    void f() { System.out.println("f()"); }
    static void g() { System.out.println("g()"); }
    public static void h() { System.out.println("h()"); }
}

class ClassWithoutStatics
{
    int a;
    String b;
    void f() { System.out.println("f()"); }
}