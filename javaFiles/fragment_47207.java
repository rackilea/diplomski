public static void main(String[] args) {
    Server s = new Server();
    s.start();
}


public Server() {
    super("Server");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(new Dimension(400, 300));
    Container c = getContentPane();
    c.setBackground(Color.BLACK);
    TA = new JTextArea();
    TA.setEditable(true);
    TA.setBackground(Color.BLACK);
    TA.setForeground(Color.GREEN);
    c.add(new JScrollPane(TA));
    setVisible(true);
    log(TA, "Server started.");
}

public void log(JTextArea txt, String message) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                txt.append(message);
            }});
}

public void start() {
    try {
        log(TA, "ServerSocket created. \n Listering for connections...");
        server = new ServerSocket(port, 2);

        for (int i = 0; i < 2; i++) {
            conn = server.accept();
            log(TA, "User " + i + " connected");
        }
    } catch (IOException ioe) {
        System.out.println(ioe);
    }
}