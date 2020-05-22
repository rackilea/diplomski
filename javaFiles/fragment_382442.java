@Override
public void run() {
    String MSG = "Hello from client, mister server!";
    Socket socket = null;
    DataOutputStream outToServer = null;
    DataInputStream inFromServer = null;

    try {
        socket = new Socket("localhost", 4321);
    } catch (IOException ioe) {
        System.out.println("Unable to connect with host: localhost. Cause: " + ioe);
        System.exit(1);
    }

    System.out.println("@Client@connected with server localhost on port 4321!");

    try {
        outToServer = new DataOutputStream(socket.getOutputStream());
        inFromServer = new DataInputStream(socket.getInputStream());
    } catch (IOException ioe) {
        System.out.println("Input and output streams creation failed. Cause: " + ioe);
        System.exit(-1);
    }

    System.out.println("@Client@created input and output streams!");

    long messageTimePerSecond = 3000;
    long elapsedTime = 0;

    try {
        for (int it = 0; it < 5; it++) {
            long messageTimeStart = System.currentTimeMillis();

            outToServer.write(MSG.getBytes());
            outToServer.flush();

            Thread.sleep((long) messageTimePerSecond);
            long messageTimeEnd = System.currentTimeMillis();
            // Measure total packet transfer time.
            long totalMessageTime = messageTimeEnd - messageTimeStart;
            System.out.println("Message " + it + ": '" + MSG + "' sent in: " + totalMessageTime);

            elapsedTime += totalMessageTime;
        }

        byte[] dataBuffer = new byte[1024];
        String echoMessage = "";
        int msgLength = 0;
        int totalData = MSG.length();
        boolean finish = false;

        while (!finish) {
            try {
                msgLength = inFromServer.read(dataBuffer);
                echoMessage += new String(dataBuffer, 0, msgLength);

                if (echoMessage.length() == totalData) {
                    finish = true;
                }

                System.out.println("ECHO MESSAGE: " + echoMessage);
            } catch (IOException e) {
                System.out.println("Hot damn");
            }
        }
    } catch (IOException | InterruptedException e) {
        System.out.println("Something bad happened. Cause: " + e);
        System.exit(-1);
    } finally {
        System.out.printf("5 Messages sent in: " + elapsedTime + " milliseconds.");
        try {
            inFromServer.close();
            outToServer.close();
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Unable to close streams and socket. Cause: " + ioe);
            System.exit(-1);
        }
    }
}