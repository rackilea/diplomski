public class Main {

    public static void main(String[] args) {
        // File parent = new File("d:/echo-insurance.backup");
        String sharedFile = "d:/echo-insurance.backup";

        try {
            Tracker tracker = new Tracker( InetAddress.getLocalHost() );
            tracker.start();
            System.out.println("Tracker running.");

            System.out.println( "create new .torrent metainfo file..." );
            Torrent torrent = Torrent.create(new File(sharedFile), tracker.getAnnounceUrl().toURI(), "createdByDarren");

            System.out.println("save .torrent to file...");

            FileOutputStream fos = new FileOutputStream("d:/seed.torrent");
            torrent.save( fos );            
            fos.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

}