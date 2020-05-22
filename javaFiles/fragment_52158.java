public class Client {

Socket s;
DataInputStream din;
DataOutputStream dout;

public Client() {

    try {
        s = new Socket("localhost", 9000);

        System.out.println(s);

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

        s1 = br.readLine();

        dout.writeUTF(s1);
        dout.flush();   

        System.out.println("Server Message: " + din.readUTF());

    } while (!s1.equals("stop"));
}

public static void main(String arg[]) {

    new Client();
}