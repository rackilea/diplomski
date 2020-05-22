public static void main(String[]args)throws Exception
{
    Socket sock = new Socket("127.0.0.1",9999);
    DataInputStream inByte = new DataInputStream(sock.getInputStream());

    System.out.println(inByte.readUTF());
    long number  = inByte.readLong();
    System.out.println(number);
}