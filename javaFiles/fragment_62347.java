public interface I{
    public String tmp();
}

public static void main(String[] args) {
    PythonInterpreter interpreter = new PythonInterpreter();
    interpreter.exec("from test import tmp");
    PyObject tmpFunction = interpreter.get("tmp");
    System.err.println(tmpFunction.getClass());
    I i = (I) x.__tojava__(I.class);
    System.err.println(i.tmp());

}