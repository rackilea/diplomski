public void sign(
    @WebParam(name = "userId", targetNamespace = "")
    String userId,
    @WebParam(name = "fileType", targetNamespace = "")
    String fileType,
    @WebParam(name = "fileContent", targetNamespace = "")
    byte[] fileContent,
    @WebParam(name = "signature", targetNamespace = "", mode = WebParam.Mode.OUT)
    Holder<byte[]> signature,
    @WebParam(name = "status", targetNamespace = "", mode = WebParam.Mode.OUT)
    Holder<String> status);