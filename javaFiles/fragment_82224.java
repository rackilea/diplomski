protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   

    /**** Define variables ****/
    Storage storage = StorageOptions.getDefaultInstance().getService();
    String bucketName = "bucketName";
    String objectName = "objectName";

    /**** Setting The Content Attributes For The Response Object ****/
    String mimeType = "application/octet-stream";
    response.setContentType(mimeType);

    /**** Setting The Headers For The Response Object ****/
    String headerKey = "Content-Disposition";
    String headerValue = String.format("attachment; filename=\"%s\"", objectName);
    response.setHeader(headerKey, headerValue);

    /**** Get the Output Stream of the Response Object****/
    OutputStream outStream = response.getOutputStream();

    /**** Call download method ****/
    run(storage, bucketName, objectName, outStream);
}

private void run(Storage storage, String bucketName, String objectName, OutputStream outStream)throws IOException {
    /**** Getting the blob ****/
    BlobId blobId = BlobId.of(bucketName, objectName);
    Blob blob = storage.get(blobId);

    /**** Writing the content that will be sent in the response ****/
    byte[] content = blob.getContent();
    outStream.write(content);
    outStream.close();
}