public class ConnectionManager {

    private Webservice webservice = null;

    public void reset() {
        synchronize(ConnectionManager.class) {
            webService = null;
        }
    }

    public Webservice getWebservice() {
        synchronize(ConnectionManager.class) {
            if(webservice == null) {
               webService = new Webservice();
            }
        }
        return webservice;
    }
}