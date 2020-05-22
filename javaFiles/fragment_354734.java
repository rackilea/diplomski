public class Main {

    public static void main (String[] args) {

        try {
            WildCoapServer server = new WildCoapServer ();
            server.start ();
        } catch  (Exception e) {
            throw new RuntimeException (e.getMessage (), e);
        }
    }
}