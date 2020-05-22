public class RequestAndResponse { // You may think up a better name
    public final Request req; // use getters if you don't like public final fields
    public final Response resp;

    public RequestAndResponse(Request req, Response resp) {
        this.req = req;
        this.resp = resp;
    }
}