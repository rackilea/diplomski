@Transactional
public void getContent(Long docId, OutputStream outputStream) {
    Blob blob = getBlob(...);
    InputStream blobStream = blob.getBinaryStream();
    copy(blobStream, outputStream);
    blobStream.close(); // ignoring the usual stream closing try/catch stuff for brevity
}