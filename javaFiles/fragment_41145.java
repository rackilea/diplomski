import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import rules.AbstractRule;

public class MainApp {
    public static void main(String[] args) {
        try {
            System.out.println("Test");
            // NB Amended here to now take project root, relative path to rules directory and class name. So that compilation can take place based on the absolute path and class loading from the relative one.
            compile("C:\\Media\\Code\\manodestra_java\\src\\tmp", "rules", "TestRule");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void compile(String projectRoot, String rulesDir, String ruleName) throws Exception {
        File parentFile = new File(projectRoot + "\\" + rulesDir + "\\");
        System.out.println(parentFile);
        String fileName = parentFile.getCanonicalPath() + "\\" + ruleName + ".java";
        File ruleFile = new File(fileName);
        System.out.println(ruleFile);

        // Compile source file.
        System.out.println("Compiling...");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, ruleFile.getPath());

        // Load and instantiate compiled class.
        System.out.println("Loading class...");
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { parentFile.toURI().toURL() });
        System.out.println("Class Loader: " + classLoader);
        ruleName = rulesDir.replace("\\", ".") + "." + ruleName;
        Class<? extends AbstractRule> clazz = (Class<? extends AbstractRule>)Class.forName(ruleName, true, classLoader);
        System.out.println(clazz);
    }
}