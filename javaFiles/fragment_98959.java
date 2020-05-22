public class Client {

    public static void main(String[] args) {
        final Context context = context(1);
        final Socket subscriber = context.socket(SUB);
        subscriber.connect("tcp://localhost:5556");

        String filter = "XXX";
        subscriber.subscribe(filter.getBytes(Charset.forName("UTF-8")));
        while (true) {
            String msg = subscriber.recvStr();
            System.out.println(msg);
        }
    }
}