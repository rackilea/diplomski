private Socket socket;
private OutputStream outputStream;
private Writer outputWriter;
private InputStream inputStream;
private Reader inputReader;

public void connect() throws IOException {
    socket = new Socket(..., ...);
    socket.setSoTimeout(60000);
    outputStream = new BufferedOutputStream(socket.getOutputStream()); // Buffered 
    outputWriter = new OutputStreamWriter(outputStream);               // Non-buffered - !important
    inputStream = new BufferedInputStream(socket.getInputStream());    // Buffered
    inputReader = new InputStreamReader(inputStream);                  // Non-buffered - !important
}