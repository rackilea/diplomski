public class ClientGame extends JFrame implements ActionListener, Runnable {  
    private Socket server = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    // IDs for CardLayout
    private static final String WAITING_PANEL_ID = "waiting";
    private static final String GAME_PANEL_ID = "game";

    private JButton[][] myButtons = new JButton[3][3];
    private JLabel waitingForPlayer = new JLabel("Waiting for other player");
    private JPanel cardPanel = new JPanel();
    private JPanel waitingForPlayerPanel = new JPanel();
    private JPanel gamePanel = new JPanel();
    private int squares = 9;

    protected boolean isTurn = false;

    ClientGame() {
        try {
            this.server = new Socket("127.0.0.1", 4444);
            this.in = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
            this.out = new PrintWriter(this.server.getOutputStream(), true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Alert", 
                    "Couldn't connect to the server.", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void initUI() {
        this.cardPanel.setLayout(new CardLayout());

        this.waitingForPlayerPanel.setLayout(new BorderLayout());
        this.waitingForPlayerPanel.setBackground(Color.white);
        this.waitingForPlayerPanel.add(BorderLayout.CENTER, this.waitingForPlayer);
        this.cardPanel.add(this.waitingForPlayerPanel, WAITING_PANEL_ID);

        this.gamePanel.setLayout(new GridLayout(3,3));
        this.gamePanel.setSize(450,450);
        this.gamePanel.setBackground(Color.white);
        this.cardPanel.add(this.gamePanel, GAME_PANEL_ID);
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                this.myButtons[i][j] = new JButton();
                this.myButtons[i][j].setPreferredSize(new Dimension(150, 150));
                this.myButtons[i][j].addActionListener(this);
                this.gamePanel.add(this.myButtons[i][j]);
            }
        }

        this.getContentPane().add(this.cardPanel);

        this.hideGamePanel();

        this.setVisible(true);

        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        this.addWindowListener(l);
    }

    // changes made here
    private void hideGamePanel() {
        CardLayout cl = (CardLayout)this.cardPanel.getLayout();
        cl.show(this.cardPanel, WAITING_PANEL_ID);
        this.pack();
    }

    // changes made here
    private void showGamePanel() {
        CardLayout cl = (CardLayout)this.cardPanel.getLayout();
        cl.show(this.cardPanel, GAME_PANEL_ID);
        this.pack();
    }
}