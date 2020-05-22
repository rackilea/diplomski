public class SomeClass {
    private ILocalDetails local = new LocalDetails();  // or something ...
    ...
    public String getServerName() {
        try {
            InetAddress addr = local.getLocalHost();
            return addr.getHostName();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}