public class MyPanel extends JPanel{

    final static String PANEL1 = "p1";
    final static String PANEL2 = "p2";

    public MyPanel(){
        super();
        this.setLayout(new CardLayout());
        this.add(getFirstDisplay(),PANEL1); 
        this.add(getSecondDisplay(),PANEL2);
    }

    private JPanel getFirstDisplay() {
        JPanel p = new JPanel();

        p.add(new JLabel("9"));

        return p;
    }

    private JPanel getSecondDisplay() {
        JPanel p = new JPanel();

        p.setLayout(new GridLayout(3, 3));

        int counter = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                p.add(new JLabel(""+counter));
                counter++;
            }
        }

        return p;
    }

    public void loadPanel(String name) {

        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, name);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sample");

        frame.setSize(400, 400);

        MyPanel myPanel = new MyPanel();

        JButton b1 = new JButton("show 1");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.loadPanel(PANEL1);
            }
        });

        JButton b2 = new JButton("show 2");
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.loadPanel(PANEL2);
            }
        });

        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(1,2));
        bot.add(b1);
        bot.add(b2);

        frame.setLayout(new BorderLayout());
        frame.add(myPanel, BorderLayout.CENTER);
        frame.add(bot, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

}