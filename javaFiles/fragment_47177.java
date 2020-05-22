/**
 * Upload Image to server
 *
 * @param file              image to be saved
 * @param compressorQuality quality of image
 * @return path of uploaded image in server
 */
private String uploadImage(Bitmap file, int compressorQuality) {
    String final_upload_filename = "demo_image.png";
    String response = null;
    HttpURLConnection conn = null;
    try {
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "---------------------------14737809831466499882746641449";
        URL url = new URL("image_upload_url");
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestProperty("ENCTYPE", "multipart/form-data");
        conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
        conn.setRequestProperty("uploaded_file", final_upload_filename);
        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.writeBytes(lineEnd + twoHyphens + boundary + lineEnd);
        dos.writeBytes("Content-Disposition: form-data; name=\"userfile\"; filename=\"" + final_upload_filename + "\"" + lineEnd);
        dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
        dos.writeBytes(lineEnd);
        file.compress(CompressFormat.PNG, compressorQuality, dos);
        dos.writeBytes(lineEnd);
        dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
        dos.flush();
        dos.close();
        InputStream is = conn.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bytesRead;
        byte[] bytes = new byte[1024];
        while ((bytesRead = is.read(bytes)) != -1) {
            baos.write(bytes, 0, bytesRead);
        }
        byte[] bytesReceived = baos.toByteArray();
        baos.close();
        is.close();
        response = new String(bytesReceived);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.disconnect();
        }
    }
    return response;
}