public class PythonCallTest {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("cmd /c python ps.py sender-ip=10.10.10.10");
    }
}