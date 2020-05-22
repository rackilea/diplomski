import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Grafika extends JPanel{

    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillArc(0, 0, 100, 100, 0, 30);
        g.setColor(Color.YELLOW);
        g.fillArc(0, 0, 100, 100, 30, 50);
        g.setColor(Color.GREEN);
        g.fillArc(0, 0, 100, 100, 50, 90);
        g.setColor(Color.BLUE);
        g.fillArc(0, 0, 100, 100, 90,120);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(300,250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new pnUserInfo());
        frame.setVisible(true);
    }
}

class pnUserInfo extends JPanel {

    public pnUserInfo() {

        setLayout(null);//missing

        JPanel pnlStatistikat = new JPanel();
        pnlStatistikat.setLayout(null);
        pnlStatistikat.setBounds(0, 0, 300, 250);
        pnlStatistikat.setBackground(Color.CYAN);
        add(pnlStatistikat); //missing
        //remove pnlStatistikat.setVisible(false);

        JPanel pnGrafik = new JPanel();
        pnGrafik.setLayout(null);
        pnGrafik.setBounds(50, 50, 200, 200);
        pnGrafik.setBackground(Color.YELLOW);

        Grafika graf = new Grafika();
        graf.setBounds(30, 30, 110, 110);//missing
        pnGrafik.add(graf);

        pnlStatistikat.add(pnGrafik);
        pnGrafik.setVisible(true);
    }}