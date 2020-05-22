public class myLocalThread extends Thread {

    private InetAddress serverAddress;
    private int serverPort;

    Socket clientSocket;
    BufferedInputStream inputStream;
    BufferedOutputStream outputStream;

    @Override
    public void run(){

        try {
            clientSocket = new Socket(serverAddress, serverPort);
            outputStream = new BufferedOutputStream(clientSocket.getOutputStream());
            inputStream = new BufferedInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        int bytes_read = 0;
        byte[] buffer = new byte[1024];

        while(true) {
             try {
                   if ((bytes_read = inputStream.read(buffer, 0, buffer.length)) > 0){

                   }
              } catch (IOException e) {
                  e.printStackTrace();
              }
        }
        outputMessage(new byte[]{(byte) 0x01});

    }

    public void outputMessage(byte[] message) throws IOException {
        outputStream.write(message);
        outputStream.flush();
    }
}