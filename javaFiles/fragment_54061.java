public static void main(String args[]) throws Exception {
    String sentence;
    String modifiedSentence;
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    Socket clientSocket = new Socket("localhost", 10000);
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    Scanner sc = new Scanner(System.in);
    while(true)
    {


        while (true) {
            String input = sc.nextLine();
            out.print(input);
            out.flush();
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER:" + modifiedSentence);
        }
    }