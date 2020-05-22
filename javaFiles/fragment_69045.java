public class MyServer implements Runnable {

    private final String[] hostnames;

    public MyServer(String... hostnames) {
        this.hostnames = hostnames;
    }

    public void run() {
       for (String hostname : hostnames) {
           // connect to hostname
       }
    }

}