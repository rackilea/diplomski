import com.sun.tools.javac.processing.PrintingProcessor;
import fi.jumi.actors.generator.JavaSourceFromString;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import javax.annotation.processing.Processor;
import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExampleTest {

    @Rule
    public final TemporaryFolder tempDir = new TemporaryFolder();

    @Test
    public void example() throws IOException {
        JavaFileObject src = new JavaSourceFromString(
                "com.example.GuineaPig",
                "package com.example;\n" +
                "public interface GuineaPig {\n" +
                "    void foo();\n" +
                "}"
        );
        compile(new PrintingProcessor(), src);
    }

    private void compile(Processor processor, JavaFileObject... compilationUnits) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(tempDir.getRoot()));

        CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null, null, Arrays.asList(compilationUnits));
        task.setProcessors(Arrays.asList(
                processor
        ));
        boolean success = task.call();
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            System.err.println(diagnostic);
        }
        assertThat("compile succeeded", success, is(true));
    }
}