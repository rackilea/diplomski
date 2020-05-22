public class DoPing implements Callable<String>{
    private final String ipToPing;

    public DoPing(String ipToPing) {
        this.ipToPing = ipToPing;
    }

    public String call() throws SomeException {
        InetAddress ipAddress = InetAddress.getByName(ipToPing);
        ....
    }
}