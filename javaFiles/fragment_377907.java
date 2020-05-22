private static String remote = "remote:localhost/";

public static void main(String[] args) {
    String dbName = "DBname";
    String path = remote + dbName;
    OServerAdmin serverAdmin;
    try {
        serverAdmin = new OServerAdmin(path).connect("root", "root");
        if (serverAdmin.existsDatabase()) {
            System.out.println("Database '" + dbName + "' already exists");
            ODatabaseDocumentTx db = new ODatabaseDocumentTx(path);
            db.open("root", "root");
            Iterable<ODocument> results = db.command(new OSQLSynchQuery<ODocument>(
                    "SELECT FROM Books WHERE 'Adventure' IN categories AND year = 1980")).execute();
            for (ODocument result : results) {
                System.out.println("Title: " + result.field("title") + "   Category: " + result.field("categories")
                        + "   Year: " + result.field("year"));
            }
            db.close();
        } else {
            serverAdmin.createDatabase(dbName, "document", "plocal");
            System.out.println("Database " + dbName + " created");
        }
        serverAdmin.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}