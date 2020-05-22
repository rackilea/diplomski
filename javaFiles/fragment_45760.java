import java.lang.reflect.*;

public class ReflectionTest{

public static void main(String[] args)
    throws Exception
{
new ReflectionTest();
}

public ReflectionTest()
    throws Exception
{

//  Class thisClass = ReflectionTest.class;
    Class thisClass = Class.forName("javax.swing.JButton");
    Field[] fields = thisClass.getFields();

    for(int i = 0; i < fields.length; i++)
    {
        System.out.println("Field #" + (i+1) + ": " + fields[i].getName());
    }

//  Method[] methods = thisClass.getDeclaredMethods();
    Method[] methods = thisClass.getMethods();

    for(int i = 0; i < methods.length; i++)
    {
        System.out.println("Method #" + (i+1) + ": " + methods[i].getName());
    }

}

public int Scooby = 1;
public String Doo;

}