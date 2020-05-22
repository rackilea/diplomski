import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        setTitle("Sample");        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new SamplePanel2());
        pack();        
        setVisible(true);
    }
}

class SamplePanel2 extends JPanel{
    public SamplePanel2(){
        add(new JButton("Hi"));
        add(new SamplePanel());
    }
}
class SamplePanel extends JPanel {
    public SamplePanel(){
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("HHHHHHHHHHHH", 100, 100);
    }
}