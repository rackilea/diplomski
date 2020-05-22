import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.PrintStream;
        import java.net.ServerSocket;
        import java.net.Socket;

        public class ServerSide {
            private PrintStream printStream;

            /**
             * @param args
             * @throws Exception
             */
            public static void main(String[] args) throws Exception{
                ServerSide serverSideInstance = new ServerSide();
                serverSideInstance.run();
            }

            /**
             * @throws Exception
             */
            public void run() throws Exception{

                ServerSocket socket = new ServerSocket(4321);
                Socket soc = socket.accept();
                InputStreamReader Inputreader = new InputStreamReader(soc.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(Inputreader);

                printStream = new PrintStream(soc.getOutputStream());

                while (true){
                    String receivedMsg =  bufferedReader.readLine();
                    System.out.println(receivedMsg);

                    // parsing client massage 
                    if(receivedMsg.trim().equalsIgnoreCase("hi")){
                        printStream.println("hi");
                        printStream.println("enter number to check: ");
                    }else if (receivedMsg.trim().equalsIgnoreCase("bye")){
                        // printStream.println("bye");
                        break;
                    }else{
                        if(isPrime(Integer.parseInt(receivedMsg))){
                            printStream.println("Yes - it is a prime number :)");
                        }else{
                            printStream.println("No - it is not a prime number :(");
                        }
                        printStream.println("enter number to check: ");
                    }
                }
            }

            private boolean isPrime(int n) {
                if (n==1) return false;

                for(int i=2;i<n;i++) {
                    if(n%i==0){
                        return false;
                    }
                }
                return true;
            }

        }