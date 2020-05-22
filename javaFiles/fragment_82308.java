class Server
{
    public static void main(String args[]) throws IOException
    {
        ...

        while(true)
        {
            DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
            serverSocket.receive(recPacket);
            System.out.println("\n Packet length: " + recPacket.getLength());
            out.write((recPacket.getData(), 0, recPacket.getLength());
            System.out.println("\nPacket" + ++i + " written to file\n");
            out.flush();
        }
    }
}