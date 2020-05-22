public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.setProperty("DEBUG_UI", "true");

                BorderLayoutFrame blf = new BorderLayoutFrame();
                blf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                blf.setSize(600,600);
                blf.setVisible(true);
            }
        });
    }

}

class BorderLayoutFrame extends JFrame implements ActionListener
{
    private final BorderLayout layout;
    private final JButton[] buttons;
    private final String names[] = {"North", "South", "East", "West", "Center"};

    public BorderLayoutFrame() {
        super( "Philosofic Problem" );
        layout = new BorderLayout( 5, 5 );
        getContentPane().setLayout( layout );
        buttons = new JButton[ names.length ];

        for (int i=0; i<names.length; i++)
        {
            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(this);
        }

        getContentPane().add(buttons[0], BorderLayout.NORTH);
        getContentPane().add(buttons[1], BorderLayout.SOUTH);
        getContentPane().add(buttons[2], BorderLayout.EAST);
        getContentPane().add(buttons[3], BorderLayout.WEST);
        getContentPane().add(new PicPanel(), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        // ignore
    }

}

class PicPanel extends JPanel
{
    private URL rUrl;
    private BufferedImage img;



    public PicPanel() {
        super();
        try {
            rUrl = getClass().getResource("UtilBtn.png");
            if (rUrl != null) {
                img = ImageIO.read(rUrl);
            }
        } catch (IOException ex) {
            Logger.getLogger(PicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);

        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

}