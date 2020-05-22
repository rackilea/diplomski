static String FILE_DIR = "./files/";

public static void main(String[] args) {

    BufferedInputStream inputStream;
    FileInputStream fileInput;

    try {

        ServerSocket socket = new ServerSocket(12345);

        while (true) {
            Socket clientSocket = socket.accept();

            /**
             * Get the file name from the client. File name is one per line.
             */
            //...put in trye-with-resources to close InputStream for us.
            try (InputStream inputFromClient = clientSocket.getInputStream()) {
                System.out.println("Connected:  Getting file name from client.");
                Scanner scanner = new Scanner(inputFromClient);
                String fileName;
                if (scanner.hasNextLine()) {
                    fileName = scanner.nextLine();
                    System.out.println("File name = " + fileName);
                } else {
                    //...no line found, continue.  consider logging an error or warning.
                    continue;
                }

                /**
                 * With fileName in hand, we can proceed to send the
                 * contents of the file to the client.
                 */
                fileInput = new FileInputStream(fileName);
                //...use DataInputStream for more portable code
                DataInputStream dataInput = new DataInputStream(fileInput);
                inputStream = new BufferedInputStream(dataInput);
                int packetToSend = -1;
                byte[] buffer = new byte[8192];

                //...consider closing the OutputStream to let the client know.
                //...use try-with-resource to close the outputStream for us.
                //...wrap your outputStream in DataOutputStream
                try (BufferedOutputStream outputStream = new BufferedOutputStream(new DataOutputStream(clientSocket.getOutputStream()))) {
                    while ((packetToSend = inputStream.read(buffer)) > -1) {
                        outputStream.write(buffer, 0, packetToSend);
                        System.out.println("sending " + packetToSend + " bytes");
                        outputStream.flush();
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}