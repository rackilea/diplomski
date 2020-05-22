public class myFirstTCPClient {
    public static void main(String[] args) throws IOException {
        String S="";
        Scanner input = new Scanner(System.in);

        // you need to provide your server ip/domain
        // InetAddress.getLocalHost() , still works but only works when 
        // your client is in the same machine. 
        Socket clntSocket = new Socket("127.0.0.1", 4999);

        while (!(S.equals("done"))){
            System.out.println("Enter a sentence");
            S = input.nextLine();
            double sent = System.nanoTime();
            PrintWriter pr = new PrintWriter(clntSocket.getOutputStream());
            pr.println(S);
            pr.flush();

            InputStreamReader in = new InputStreamReader(clntSocket.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Message from server: " + str);
            double received = System.nanoTime();
            double total = received - sent;
            System.out.println("Round Trip Time: " + (total/1000000.0));
        }
        clntSocket.close();
    }
}