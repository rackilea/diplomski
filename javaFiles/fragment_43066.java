package hello;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class Snippet {

    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        List<File> sourceFiles = Arrays.asList(new File("C://project//src//hello//Hello.java"));
        Iterable<? extends JavaFileObject> compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(sourceFiles);
        try {
            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File("C://project//classes//")));
            if(!compiler.getTask(null, fileManager, null, null, null, compilationUnits1 ).call())
                throw new IllegalStateException("Error on compiling API");
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}