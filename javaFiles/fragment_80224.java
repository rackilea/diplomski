public void connect() throws WebSocketException {
    try {
        if (connected) {
            throw new WebSocketException("already connected");
        }

        socket = createSocket();
        input = new DataInputStream(socket.getInputStream());
        output = new PrintStream(socket.getOutputStream());

        output.write(handshake.getHandshake());

        boolean handshakeComplete = false;

        ArrayList<String> handshakeLines = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(input);

        String handshakeData;
        while ((handshakeData = reader.readLine()) != null) {
            if (handshakeData.trim().equals("")) {
               handshakeComplete = true;
               break;
            }
            handshakeLines.add(handshakeData);
        }

        if (!handshakeComplete)
            throw new WebSocketException ("Failed to establish handshake.");