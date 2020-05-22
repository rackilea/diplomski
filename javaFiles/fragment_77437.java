/* Usage
--------
$ javac CompileJarLoadReflect.java
$ java CompileJarLoadReflect MyClass YourClass CompileJarLoadReflect
MyClass.java compilation is successful
YourClass.java compilation is successful
CompileJarLoadReflect.java compilation is successful
3 files successfully compiled
Class MyClass
    myMethod
Class YourClass
    yourMethod
Class CompileJarLoadReflect
    main
    compile
    compile
    load
    jar
*/

/* Thanks to
------------
http://www.java2s.com/Code/Java/File-Input-Output/CreateJarfile.htm
http://stackoverflow.com/questions/194698/how-to-load-a-jar-file-at-runtime/673414#673414
*/

import javax.tools.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;


/** Simple compilation, packaging and loading example */
public class CompileJarLoadReflect {
    /** JAR buffer size*/
    public static int BUFFER_SIZE = 10 * 1024;

    /** Compile all files given (by their location) */
    public void compile(String[] files) throws Exception {
        for (String f : files) compile(f + ".java");
        System.out.println(files.length + " files successfully compiled");
    }

    /** Compile one particular file */
    protected void compile(String f) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, f);

        if (compilationResult == 0) System.out.println(f + " compilation is successful");
        else throw new Exception("Compilation error at file " + f);
    }

    /** Pack tobeJared classes into jarName */
    public void jar(String jarName, String[] tobeJared) throws Exception {
        File archiveFile = new File(jarName);
        byte buffer[] = new byte[BUFFER_SIZE];

        FileOutputStream stream = new FileOutputStream(archiveFile);
        JarOutputStream out = new JarOutputStream(stream, new Manifest());

        for (String name : tobeJared) {
            File f = new File(name + ".class");
            if (f == null || !f.exists() || f.isDirectory()) throw new Exception("Jar problem at file " + name);

            JarEntry jarAdd = new JarEntry(f.getName());
            jarAdd.setTime(f.lastModified());
            out.putNextEntry(jarAdd);

            FileInputStream in = new FileInputStream(f);
            while (true) {
                int nRead = in.read(buffer, 0, buffer.length);
                if (nRead <= 0) break;
                out.write(buffer, 0, nRead);
            }
            in.close();
        }

        out.close();
        stream.close();
    }

    /** Load jar archive at jarName and then print methods of all classes in clazzes  */
    public void load(String jarName, String[] clazzes) throws Exception {
        File file  = new File(jarName);
        URL url = file.toURL();  
        URL[] urls = new URL[]{url};
        ClassLoader cl = new URLClassLoader(urls);

        for (String c : clazzes) {
            System.out.println("Class " + c);
            Class cls = cl.loadClass(c);
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) System.out.println("\t" + m.getName());
        }
    }

    /** Try everyting out, use params without .java */
    public static void main(String[] args) {
        String jarName = "output.jar";

        try {
            CompileJarLoadReflect cjlr = new CompileJarLoadReflect();
            cjlr.compile(args);
            cjlr.jar(jarName, args);
            cjlr.load(jarName, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}