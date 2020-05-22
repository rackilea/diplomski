import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;

import java.io.File;
import java.io.IOException;

public class Parser {

    public void parseFile() throws IOException {
        File file = new File("/path/to/testClass.java");

        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(file);

        for (JavaClass javaClass : builder.getClasses()) {
            if (javaClass.getName().equals("testClass")) {
                for (JavaMethod javaMethod : javaClass.getMethods()) {
                    if (javaMethod.getName().equals("testMethod")) {
                        System.out.println(javaMethod.getSourceCode());
                    }
                }
            }
        }
    }
}