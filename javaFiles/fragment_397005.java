public class Test extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;

    public Test() {
        initialize();
    }

    LongRunProcess process;

    private void initialize() {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton startButton = new JButton("Start");
        final JButton stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    process = new LongRunProcess();
                    process.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(null, "Hello There");

                process.closeServer();

                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                process.stop();
            }
        });

        this.getContentPane().add(startButton);
        this.getContentPane().add(stopButton);

        this.pack();
        this.setSize(new Dimension(300, 80));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    class LongRunProcess extends Thread {
        /**
         * @throws Exception
         */
        public void closeServer() {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Closed Now");
        }

        public void run() {
            try {
                serverSocket = new ServerSocket(4545); // Server socket

            } catch (IOException e) {
                System.out.println("Could not listen on port: 4545");
            }

            System.out.println("Server started. Listening to the port 4545");

            while (!(serverSocket.isClosed())) {
                try {

                    clientSocket = serverSocket.accept(); // accept the client
                                                            // connection
                    inputStreamReader = new InputStreamReader(
                            clientSocket.getInputStream());
                    bufferedReader = new BufferedReader(inputStreamReader); // get
                                                                            // the
                                                                            // client
                                                                            // message
                    message = bufferedReader.readLine();
                    if (message.equals("shutdown")) {

                        Runtime runtime = Runtime.getRuntime();
                        Process proc = runtime.exec("shutdown -s -t 00");
                        System.exit(0);

                    } else if (message.equals("restart")) {
                        Runtime runtime1 = Runtime.getRuntime();
                        Process proc2 = runtime1.exec("shutdown -r -t 00");
                        System.exit(0);

                    }

                    System.out.println(message);
                    inputStreamReader.close();
                    clientSocket.close();

                } catch (IOException ex) {
                    System.out.println("Problem in message reading");
                }
            }
        }
    }
}