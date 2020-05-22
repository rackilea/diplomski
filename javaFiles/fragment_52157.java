public class Server {

ServerSocket ss;
Socket s;
DataInputStream din;
DataOutputStream dout;

public Server() {

    try {

        System.out.println("Server START......");

        ss = new ServerSocket(9000);
        s = ss.accept();

        System.out.println("Client Connected.....");

        din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream());
        chat();
    } catch (Exception e) {
        System.out.println(e);
    }
}

public void chat() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s1;

    do {

        System.out.println("Client Message: " + din.readUTF());

        s1=br.readLine();
        dout.writeUTF(s1);
        dout.flush();

    } while (!s1.equals("stop"));
}

public static void main(String arg[]) {

    new Server();
}