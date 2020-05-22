class Client {
    private Socket clientSocket;

    public void connectToServer()
    {
        String sServer="localhost";
        int PORT = 8181;
        try {
            InetAddress host = InetAddress.getByName(sServer);
            clientSocket = new Socket(host, PORT);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String sText,int iCommand) throws IOException {
        Message outMessage = new Message();

        outMessage.setCOMMAND(iCommand);
        outMessage.setsMessage(sText);

        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        try {
            oos.writeObject(outMessage);
            oos.flush();
            oos.reset();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.connectToServer();
        try {
            c.sendMessage("test message", 42);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Message implements Serializable {
    private int iCommand;
    private String sText;

    public void setCOMMAND(int iCommand) {
        this.iCommand = iCommand;
    }

    public void setsMessage(String sText) {
        this.sText = sText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "iCommand=" + iCommand +
                ", sText='" + sText + '\'' +
                '}';
    }
}