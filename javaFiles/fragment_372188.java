public class SocketsServer {

    public static void main(String[]rags) throws Exception
    {
        ServerSocket ss1 = new ServerSocket();
        ss1.bind(new InetSocketAddress("localhost",9992));
        //accept blocks until someone connects
        Socket s1 = ss1.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        String line;
        while( (line = br.readLine()) != null )
        {
            System.out.println(line);
        }
        s1.close();
        ss1.close();
    }
}