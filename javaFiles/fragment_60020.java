public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file"));
        String line;
        State state = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(".")) {
                // detect state
            } else {
                // handle data for state
            }
        }
    }

    static enum State {
        CUSTOMER, PRODUCTS, STATE;
    }
}