import java.io.*;
import java.util.*;

import org.objectweb.asm.ClassReader;

public class Test {

    public static void main(String[] args) throws Exception {

        File dir = new File(args[0]);

        Map<String, Set<String>> callMap = new HashMap<String, Set<String>>();

        List<File> classFiles = new LinkedList<File>();
        findClassFiles(classFiles, dir);

        for (File classFile : classFiles) {
            InputStream input = new FileInputStream(classFile);
            new ClassReader(input).accept(new MyClassVisitor(callMap), 0);
            input.close();
        }

        for (Map.Entry<String, Set<String>> entry : callMap.entrySet()) {
            String method = entry.getKey();
            Set<String> callers = entry.getValue();

            if (callers != null && !callers.isEmpty()) {
                System.out.println(method);
                for (String caller : callers) {
                    System.out.println("    " + caller);
                }
            }
        }
    }

    private static void findClassFiles(List<File> list, File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                findClassFiles(list, file);
            } else if (file.getName().endsWith(".class")) {
                list.add(file);
            }
        }
    }
}