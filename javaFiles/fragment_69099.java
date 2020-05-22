public byte[] toByteArray(InputStream is) throws IOException{
    ByteArrayOutputStream baus = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int len;
    while((len= is.read(buffer)) != -1){
        baus.write(buffer, 0, len);
    }
    return baus.toByteArray();
}

@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadFile(
                @FormDataParam("file") InputStream uploadedInputStream,
                @FormDataParam("file") FormDataContentDisposition fileDetail) {
    ...
    byte[] b = toByteArray(uploadedInputStream);
    business.saveUploadedFileInDatabase(b);
    ...
}

public boolean uploadFile(byte[] b) throws SQLException, IOException{
    ...
    PreparedStatement ps = conn.prepareStatement("INSERT INTO TABLE_IMAGE_TEST (CODE, IMAGE) VALUES (?, ?)");
    pstmt.setLong(1, 1L);
    pstmt.setBytes(2, b);
    pstmt.execute();
    ...
}