import org.python.util.PythonInterpreter;

public class JythonTest {
    public static void main(String[] args) {
        PythonInterpreter interp = new PythonInterpreter();
        interp.exec("if 2 > 1: print 'in if statement!'");
    }
}