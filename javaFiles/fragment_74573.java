@Override
public Void call() throws Exception {
    InputStream in = connection.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
    readHeader(reader);
    System.out.println("incoming message : " + header.get("Method"));

    // read binary Content
    int bytesRead = 0;
    int bytesToRead = Integer.parseInt(header.get("Content-Length"));
    content = new byte[bytesToRead];
    while (bytesRead < bytesToRead) {
        int result = in.read(content, bytesRead, bytesToRead - bytesRead);
        if (result == -1) 
            break; // end of stream
        bytesRead += result;
    }
    return null;
}