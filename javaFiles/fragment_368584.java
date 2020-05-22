public class UDPThreadServer extends Thread
{

  public static int port1;

  UDPThreadServer()
  {
    //server or client?  it's hard to say.  you call the socket a clientSocket.
    System.out.println("Starting threaded server");
    start();
  }

  public void run()
  {
    try
    {
      // Here client(?) is set up with empty constructor.
      // It is a mystery what port it will get.
      DatagramSocket clientSocket = new DatagramSocket();

      BufferedReader inFromUser =
          new BufferedReader(new InputStreamReader(System.in));
      Scanner in = new Scanner(inFromUser);
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];

      while (in.hasNextLine())
      {
        String sentence = in.nextLine();
        // inFromUser.readLine();
        sendData = sentence.getBytes();

        // sending to port1?  that must be the server.
        DatagramPacket sendPacket =
            new DatagramPacket(sendData, sendData.length, IPAddress, port1);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket =
            new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String modSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER: " + modSentence);
      }
      // clientSocket.close();
    } catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  // Create server
  public static void main(String[] args)
  {

    // int port = Integer.parseInt(args[0]);
    int port = 1927; // or whatever
    // port1 = Integer.parseInt(args[1]);
    port1 = 1928;
    new UDPThreadServer();
    try
    {
      // server resides on port1?  if client sends to port 1, then this is so.
      DatagramSocket serverSocket = new DatagramSocket(port1);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];

      while (true)
      {
        DatagramPacket receivePacket =
            new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        SocketAddress address = receivePacket.getSocketAddress();
        System.out.println("Received from " + address + " : " + sentence);

        InetAddress IPAddress = receivePacket.getAddress();
        String capSentence = sentence.toUpperCase();
        sendData = capSentence.getBytes();

        // where did you get the info from?  Client is set up with an empty constructor, so it is a mystery.
        port = receivePacket.getPort();

        DatagramPacket sendPacket =
            new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
        // serverSocket.close();
      }

    } catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
}