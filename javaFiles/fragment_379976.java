import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.PrintStream;
    import java.net.Socket;

    public class ClientSide {
        /**
         * @param args
         * @throws Exception
         */
        public static void main(String[] args) throws Exception{
            ClientSide clientSideInstance = new ClientSide();
            clientSideInstance.run();
        }

        /**
         * @throws Exception
         */
        public void run() throws Exception{
            BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
            Socket soc = new Socket("localhost", 4321);
            PrintStream printStream = new PrintStream(soc.getOutputStream());
            printStream.println("hi");

            InputStreamReader Inputreader = new InputStreamReader(soc.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(Inputreader);
            String receivedMsg =  bufferedReader.readLine().trim();
            System.out.println(receivedMsg);

            while (true){
                receivedMsg =  bufferedReader.readLine();
                System.out.println(receivedMsg);

                if (receivedMsg.equalsIgnoreCase("enter number to check: ")){
                    String userMessage = brr.readLine().trim(); // read from stdin
                    printStream.println(userMessage); // send message/number to server
                    if (userMessage.equalsIgnoreCase("bye")){
                        break;
                    }
                    receivedMsg =  bufferedReader.readLine().trim();
                    System.out.println(receivedMsg);
                }
            }
        }
    }