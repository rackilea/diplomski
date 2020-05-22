public class Object {

    private Credentials credentials;
    private int PageSize;
    private int PageStart;
    private int DefaultFilterId;

    public Object(Credentials credentials, int PageSize, int PageStart, int DefaultFilterId) {
        this.credentials = credentials;
        this.PageSize = PageSize;
        this.PageStart = PageStart;
        this.DefaultFilterId = DefaultFilterId;
    }

    // do that for the properties you want to be able to modify
    public void setCredentials(Credentials newCredentials) {
         this.credentials = newCredentials;
    }

}