import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Preloader
{
    public static void main(String[] args) throws Exception
    {

        Class<Preloader> c= Preloader.class;

        URLClassLoader loader = new URLClassLoader(new URL[]{
            c.getResource("program.jar"),
            c.getResource("library.jar")});

        Class<?> main_class=loader.loadClass("Main");
        Method main_method = main_class.getMethod("main", args.getClass());
        main_method.invoke(null, new Object[]{args});

    }
}