public class Fenetre extends JFrame {

    public Fenetre(){
        super("Test");
        init();
        //pack();
        setSize(200,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button = new JButton("Draw line");

        button.addActionListener((e)->{
            Pane s = new Pane();
            panel.add(s);
            panel.revalidate();
            panel.repaint();
            //s.repaint();
        });

        panel.setBackground(new Color(149,222,205));

        add(button,BorderLayout.SOUTH);
        add(panel,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        new Fenetre();
    }

}