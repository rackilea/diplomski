import play.api.mvc.RequestHeader;

public class DocumentIssuedMailWrapper {
    private DocumentIssuedMail documentIssuedMail;
    private RequestHeader requestHeader;

    public DocumentIssuedMailWrapper(DocumentIssuedMail documentIssuedMail, RequestHeader requestHeader) {
        this.documentIssuedMail = documentIssuedMail;
        this.requestHeader = requestHeader;
    }

    public DocumentIssuedMail getDocumentIssuedMail() {
        return documentIssuedMail;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }
}