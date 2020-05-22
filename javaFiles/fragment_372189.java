public class SocketsClient {

    public static void main(String[]args) throws Exception
    {
        Socket ss = new Socket();
        ss.connect(new InetSocketAddress("localhost", 9992));
        PrintWriter pw = new PrintWriter(ss.getOutputStream(), true);
        pw.println("hello socket");
        ss.close();
    }
}