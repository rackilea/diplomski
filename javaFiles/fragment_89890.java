// OutputStream os = response.getOutputStream();  // earlier
// Blob blob = resultSet.getBlob("data_binary");  // earlier
// OutputStream cacheOut
final int bufSize = 4096;
byte[] buffer = new byte[bufSize];
int length;
try (InputStream is = blob.getBinaryStream()) {
    while ((length = is.read(buffer, 0, bufSize)) != -1) {
        out.write(buffer, 0, length);
        out.flush();
        cacheOut.write(buffer, 0, length);
    }
    out.flush();
    cacheOut.close();
}