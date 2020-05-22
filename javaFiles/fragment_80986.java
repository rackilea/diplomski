public class myFirstTCPServer {
    public static void main(String[] args) throws IOException {

        int servPort = 4999;
        ServerSocket Sy = new ServerSocket(servPort);
        Socket servSocket = Sy.accept();
        System.out.println("client connected");

        InputStreamReader in = new InputStreamReader(servSocket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str ="";
        while (true)){

            str = bf.readLine();

            if(str.equals("done")) break;

            InetAddress address = servSocket.getInetAddress();
            String ip = address.getHostAddress();
            System.out.println("IP: " + ip);
            System.out.println("Port: " + servPort);

            System.out.println("Message from client: " + str);

            PrintWriter pr = new PrintWriter(servSocket.getOutputStream());
            pr.println(str.toUpperCase());
            pr.flush();
        }
        servSocket.close();
    }
    }