public static boolean upload_image5(String urls,File file, String encoding){
    HttpURLConnection connection = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;
    String myfilename = file.getName();
    String urlServer = urls;
    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";
    boolean erg = false;
    int bytesRead, bytesAvailable, bufferSize;
    byte[] buffer;
    int maxBufferSize = 1*1024*1024;

    try
    {
    FileInputStream fileInputStream = new FileInputStream(file);

    URL url = new URL(urlServer);
    connection = (HttpsURLConnection) url.openConnection();

    // Allow Inputs & Outputs
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setUseCaches(false);

    // Enable POST method
    connection.setRequestMethod("POST");

    connection.setRequestProperty("Connection", "Keep-Alive");
    connection.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
    connection.addRequestProperty("Authorization","Basic [YOUR MD5 LOGIN VALUE]");
    outputStream = new DataOutputStream( connection.getOutputStream() );
    outputStream.writeBytes(twoHyphens + boundary + lineEnd);

    outputStream.writeBytes("Content-Disposition: form-data; name=\"DestFileName\"");
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(myfilename);
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(twoHyphens + boundary + lineEnd);
    outputStream.writeBytes("Content-Disposition: form-data; name=\"Target\"" );
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes("DOC");
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(twoHyphens + boundary + lineEnd);
    outputStream.writeBytes("Content-Disposition: form-data; name=\"filename\"");
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(myfilename);
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(twoHyphens + boundary + lineEnd);
    outputStream.writeBytes("Content-Disposition: form-data; name=\"File\"; filename=\"" + myfilename + "\"");
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes("Content-Type: application/*");
    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(lineEnd);
    //hier File schreiben
    bytesAvailable = fileInputStream.available();
    bufferSize = Math.min(bytesAvailable, maxBufferSize);
    buffer = new byte[bufferSize];
    bytesRead = fileInputStream.read(buffer, 0, bufferSize);

    while (bytesRead > 0)
    {
    outputStream.write(buffer, 0, bufferSize);
    bytesAvailable = fileInputStream.available();
    bufferSize = Math.min(bytesAvailable, maxBufferSize);
    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
    }

    outputStream.writeBytes(lineEnd);
    outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);


    fileInputStream.close();


    try {
        inputStream = new DataInputStream(connection.getInputStream()); 
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = inputStream.readLine()) != null) {
            response.append(line).append('\n');
        }
        LastError =response.toString();
        erg = true;
    } catch (IOException e) { 
        LastError = e.getMessage();
        erg = false;
    } finally { 
        if (inputStream != null){
            try { 
                inputStream.close(); 
            } catch (IOException e) { 
                e.printStackTrace();
            } 
        }
    }

    outputStream.flush();
    outputStream.close();
    }
    catch (Exception ex)
    {
        LastError = ex.getMessage();
        erg = false;
    }
    return erg;
}