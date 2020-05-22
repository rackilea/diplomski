@Override
public void handle(HttpExchange t) throws IOException {
    String CRLF = "\r\n";
    int fileSize = 0;

    String FILE_TO_RECEIVED = "C://root//m"+musikerid+"hp"+(hörprobenzaehler+1)+".mid";
    File f = new File(FILE_TO_RECEIVED);
    if (!f.exists()) {
        f.createNewFile();
    }

    InputStream input = t.getRequestBody();
    String nextLine = "";
    do {
        nextLine = readLine(input, CRLF);
        if (nextLine.startsWith("Content-Length:")) {
            fileSize = 
                Integer.parseInt(
                    nextLine.replaceAll(" ", "").substring(
                        "Content-Length:".length()
                    )
                );
        }
        System.out.println(nextLine);
    } while (!nextLine.equals(""));

    byte[] midFileByteArray = new byte[fileSize];
    int readOffset = 0;
    while (readOffset < fileSize) {
        int bytesRead = input.read(midFileByteArray, readOffset, fileSize);
        readOffset += bytesRead;
    }

    BufferedOutputStream bos = 
        new BufferedOutputStream(new FileOutputStream(FILE_TO_RECEIVED));

    bos.write(midFileByteArray, 0, fileSize);
    bos.flush();

    t.sendResponseHeaders(200, 0);
}

private static String readLine(InputStream is, String lineSeparator) 
    throws IOException {

    int off = 0, i = 0;
    byte[] separator = lineSeparator.getBytes("UTF-8");
    byte[] lineBytes = new byte[1024];

    while (is.available() > 0) {
        int nextByte = is.read();
        if (nextByte < -1) {
            throw new IOException(
                "Reached end of stream while reading the current line!");
        }

        lineBytes[i] = (byte) nextByte;
        if (lineBytes[i++] == separator[off++]) {
            if (off == separator.length) {
                return new String(
                    lineBytes, 0, i-separator.length, "UTF-8");
            }
        }
        else {
            off = 0;
        }

        if (i == lineBytes.length) {
            throw new IOException("Maximum line length exceeded: " + i);
        }
    }

    throw new IOException(
        "Reached end of stream while reading the current line!");       
}