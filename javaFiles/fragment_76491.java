import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader {

public static void main(String[] args) {
    try {
        URLClassLoader clsLoader = URLClassLoader.newInstance(new URL[] {new URL("file:/C://ambienteDesenv/bitbucket/testJar.jar")});
        Class cls = clsLoader.loadClass("testeJar.TestClass");

        Method m = cls.getMethod("getValue");
        Object a = m.invoke(cls.newInstance());
        System.out.println(a);


    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | MalformedURLException | InstantiationException e) {
        e.printStackTrace();
    }
}
}