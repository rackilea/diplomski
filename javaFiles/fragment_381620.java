package classdep;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jedo.classfile.ClassFile;
import org.jedo.classfile.ConstantPool;

public class Main {

    public static void main(String[] args) {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            List<String> classes = new ArrayList<String>();
            classes.add(args[0].replace('.', '/'));
            for (int i = 0; i < classes.size(); ++i) {
                String className = classes.get(i);
                URL url = cl.getResource(className + ".class");
                if (url == null) {
                    System.out.println("--- class not found " + className);
                } else {
                    System.out.println(url);
                    ClassFile classFile = new ClassFile();
                    InputStream in = url.openStream();
                    try {
                        classFile.load(in);
                    } finally {
                        in.close();
                    }
                    ConstantPool cp = classFile.getConstantPool();
                    for (String name: cp.getClassNames()) {
                        if (!classes.contains(name)) {
                            classes.add(name);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}