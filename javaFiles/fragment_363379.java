import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ArgCounting
{
    static class Entry
    {
        Class<?> clazz;
        Executable executable;
        int numParams;
    }

    public static void main(String[] args) throws Exception
    {
        List<Entry> entries = new ArrayList<Entry>();
        ClassFinder.findClasses(new Visitor<String>()
        {
            @Override
            public boolean visit(String clazz)
            {
                try
                {
                    System.out.println(clazz);
                    Class<?> c = Class.forName(clazz);
                    Method[] methods = c.getDeclaredMethods();
                    for (Method method : methods)
                    {
                        Entry entry = new Entry();
                        entry.clazz = c;
                        entry.executable = method;
                        entry.numParams = method.getParameterCount();
                        entries.add(entry);
                    }
                    Constructor<?>[] constructors = c.getDeclaredConstructors();
                    for (Constructor<?> constructor : constructors)
                    {
                        Entry entry = new Entry();
                        entry.clazz = c;
                        entry.executable = constructor;
                        entry.numParams = constructor.getParameterCount();
                        entries.add(entry);
                    }
                }
                catch (Throwable e)
                {
                    System.out.println("Ignoring: " + e);
                }
                return true;
            }
        });

        System.out.println("There are " + entries.size() + " executables");

        Predicate<Entry> executableIsNotNative = 
            e -> !Modifier.isNative(e.executable.getModifiers());
        Predicate<Entry> executableIsPublic = 
            e -> Modifier.isPublic(e.executable.getModifiers());
        Predicate<Entry> executableIsProtected = 
            e -> Modifier.isProtected(e.executable.getModifiers());
        Predicate<Entry> classIsPublic = 
            e -> Modifier.isPublic(e.clazz.getModifiers());

        List<String> skippedPackagePrefixes = Arrays.asList(
            "sun.", "com.sun.");
        Predicate<Entry> isSkipped = e -> 
        {
            for (String prefix : skippedPackagePrefixes) 
            {
                Package p = e.clazz.getPackage();
                if (p != null)
                {
                    if (p.getName().startsWith(prefix))
                    {
                        return true;
                    }
                }
            }
            return false;
        };
        Predicate<Entry> isNotSkipped = isSkipped.negate();

        Predicate<Entry> executableIsRelevant = 
                executableIsNotNative.and(executableIsPublic.or(executableIsProtected));

        System.out.println("Methods:");
        printAllMax(entries, 
            classIsPublic.and(executableIsRelevant).and(isNotSkipped).and(e -> e.executable instanceof Method));

        System.out.println("Constructors:");
        printAllMax(entries, 
            classIsPublic.and(executableIsRelevant).and(isNotSkipped).and(e -> e.executable instanceof Constructor));
    }

    private static void printAllMax(Collection<Entry> entries, Predicate<Entry> filter)
    {
        int max = entries.stream()
                .filter(filter)
                .mapToInt(e -> e.numParams)
                .max()
                .getAsInt();

        System.out.println("Having " + max + " parameters:");
        entries.stream().filter(filter.and(e -> e.numParams == max)).forEach(e -> 
        {
            System.out.println(e.executable);
        });
    }

}

// From https://stackoverflow.com/a/19554704/3182664
interface Visitor<T>
{
    /**
     * @return {@code true} if the algorithm should visit more results,
     *         {@code false} if it should terminate now.
     */
    public boolean visit(T t);
}

// From https://stackoverflow.com/a/19554704/3182664
class ClassFinder
{
    public static void findClasses(Visitor<String> visitor)
    {
        String classpath = System.getProperty("java.class.path");
        String[] paths = classpath.split(System.getProperty("path.separator"));

        String javaHome = System.getProperty("java.home");
        File file = new File(javaHome + File.separator + "lib");
        if (file.exists())
        {
            findClasses(file, file, true, visitor);
        }

        for (String path : paths)
        {
            file = new File(path);
            if (file.exists())
            {
                findClasses(file, file, false, visitor);
            }
        }
    }

    private static boolean findClasses(File root, File file,
        boolean includeJars, Visitor<String> visitor)
    {
        if (file.isDirectory())
        {
            for (File child : file.listFiles())
            {
                if (!findClasses(root, child, includeJars, visitor))
                {
                    return false;
                }
            }
        }
        else
        {
            if (file.getName().toLowerCase().endsWith(".jar") && includeJars)
            {
                JarFile jar = null;
                try
                {
                    jar = new JarFile(file);
                }
                catch (Exception ex)
                {

                }
                if (jar != null)
                {
                    Enumeration<JarEntry> entries = jar.entries();
                    while (entries.hasMoreElements())
                    {
                        JarEntry entry = entries.nextElement();
                        String name = entry.getName();
                        int extIndex = name.lastIndexOf(".class");
                        if (extIndex > 0)
                        {
                            if (!visitor.visit(
                                name.substring(0, extIndex).replace("/", ".")))
                            {
                                return false;
                            }
                        }
                    }
                }
            }
            else if (file.getName().toLowerCase().endsWith(".class"))
            {
                if (!visitor.visit(createClassName(root, file)))
                {
                    return false;
                }
            }
        }

        return true;
    }

    private static String createClassName(File root, File file)
    {
        StringBuffer sb = new StringBuffer();
        String fileName = file.getName();
        sb.append(fileName.substring(0, fileName.lastIndexOf(".class")));
        file = file.getParentFile();
        while (file != null && !file.equals(root))
        {
            sb.insert(0, '.').insert(0, file.getName());
            file = file.getParentFile();
        }
        return sb.toString();
    }
}