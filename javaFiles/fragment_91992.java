import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLClassLoader;
import java.util.*;
import java.util.logging.Logger;
import javax.tools.*;

public final class CompileString {

    static class JavaSourceFromString extends SimpleJavaFileObject {
        private final String code;

        JavaSourceFromString(final String name, final String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(final boolean ignoreEncodingErrors) {
            return code;
        }
    }

    private CompileString() {}

    private static final Logger LOG = Logger.getLogger(CompileString.class.getCanonicalName());

    private static final JavaCompiler COMPILER = ToolProvider.getSystemJavaCompiler();
    public static void main(final String...args) {

        final String program =
            "public class Test{" +
            "   public static void main (String [] args) {" +
            "      System.out.println (\"Hello, World\");" +
            "      System.out.println (args.length);" +
            "   }" +
            "}";

        final List <JavaSourceFromString> fileObjects = List.of(new JavaSourceFromString("Test", program));

        final boolean result = COMPILER.getTask(null, null, null, null, null, fileObjects).call();
        LOG.info("Compilation result was: " + result);

        final URL url;
        try {
            url = new File("./").toURI().toURL();
        } catch (final MalformedURLException ex) {
            throw new AssertionError("Bad URL? (Really shouldn't happen)", ex);
        }

        try (URLClassLoader loader = new URLClassLoader(new URL[] {url})) {
            final Class<?> clazz = loader.loadClass("Test");
            final Method main = clazz.getMethod("main", String[].class);
            final Object[] invocationArguments = {new String[] {}};
            main.invoke(null, invocationArguments);
        } catch (final ClassNotFoundException ex) {
            throw new AssertionError("Bad class name", ex);
        } catch (final IOException ex) {
            throw new AssertionError("IO Error", ex);
        } catch (final NoSuchMethodException ex) {
            throw new AssertionError("Missing main method", ex);
        } catch (final IllegalAccessException ex) {
            throw new AssertionError("Class or main method not public", ex);
        } catch (final InvocationTargetException ex) {
            throw new AssertionError("Exception thrown by main method", ex);
        }
    }

}