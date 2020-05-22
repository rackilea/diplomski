public class InputStreamDebugTest {

public static class MyReader extends BufferedReader {

    private final InputStream in;

    public MyReader(InputStream in) {
        super(new InputStreamReader(in));
        this.in = in;
    }

    @Override
    public String toString() {
        try {
            return "available: " + in.available();
        } catch (IOException e) {
            return "Exception: " + e.getMessage();
        }
    }

}

public static void main(String[] args) throws IOException {

    MyReader in = new MyReader(new ByteArrayInputStream("Just some minor text for debugging".getBytes()));
    while (true) {
        System.out.println(in.read());
    }

}

}