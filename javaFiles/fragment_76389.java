public class OracleAQBLOBUtil {

    public BLOB createBlob(OracleConnection conn, byte[] payload) throws Exception {
        BLOB blob = BLOB.createTemporary(conn, false, BLOB.DURATION_SESSION);
        OutputStream outputStream = blob.setBinaryStream(1L);
        InputStream inputStream = new ByteArrayInputStream(payload);
        try {
            byte[] buffer = new byte[blob.getBufferSize()];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return blob;
        }
        finally {
            outputStream.close();
            inputStream.close();
        }
    }

    public byte[] saveOutputStream(BLOB blob) throws Exception {
        InputStream inputStream = blob.getBinaryStream();
        int counter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((counter = inputStream.read()) > -1) {
            byteArrayOutputStream.write(counter);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

}