@WebEndpoint(name = "FileUploadSoap")
public FileUploadSoap getFileUploadSoap() {
    FileUploadSoap fileUploadSoap = super.getPort(new QName(
            "http://svc.qleapahead.com/", "FileUploadSoap"),
            FileUploadSoap.class);
    ((BindingProvider) fileUploadSoap).getRequestContext().put(
            "com.sun.xml.internal.ws.request.timeout", 1000 * 2 * 60);
    return fileUploadSoap;
}