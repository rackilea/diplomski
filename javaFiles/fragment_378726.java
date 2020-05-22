import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
public class Main {

    public static B create() 
    {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("from D import D");
        PyObject DClass = interpreter.get("D");

        PyObject DObject = DClass.__call__();
        return (B)DObject.__tojava__(B.class);
    }

    public static void main(String[] args) 
    {
        B b = create();
        System.out.println(b.FooBar("Wall-"));
    }
}