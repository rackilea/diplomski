public class MyOutputStream extends FilterOutputStream {

    private String clientId;
    private String fileId;
    private String fileLocation;
    private DBClient clientobj;

    public static MyOutputStream create(String clientId, String fileId, String fileLocation) {
        DBClient clientobj = DBClient.getInstance(clientId, fileId);
        return new MyOutputStream(clientId, fileId, fileLocation, clientobj);
    }

    private MyOutputStream(String clientId, String fileId, String fileLocation, DBClient clientobj) {
        super(clientobj.getOutputStream());
        this.clientId = clientId;
        this.fileId = fileId;
        this.fileLocation = fileLocation;
        this.clientobj = clientobj;
    }

}