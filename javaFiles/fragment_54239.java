public class Main {

    public static void main(String[] args) {
        TrackingImportXmlApplicationContext applicationContext = new TrackingImportXmlApplicationContext("/META-INF/applicationContext.xml");
        TrackingImportXmlApplicationContext.TrackingImportReaderEventListener tracking = applicationContext.getTrackingImportReaderEventListener();
        for (String _import : tracking.getImports()) {
            System.out.println(" >>> imported : " + _import);
        }
    }
}