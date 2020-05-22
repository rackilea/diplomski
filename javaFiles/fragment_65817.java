import javax.swing.*;
import java.awt.*;

class ChordEditor extends JPanel {

    public ChordEditor() {
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("entering paint function");
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        System.out.println("drawing line");
        g2d.drawLine(10, 10, 40, 40);
        //g.dispose();
    }

    public static void main(String[] args) {
        JFrame m_frame = new JFrame();
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(600, 400);
        m_frame.setVisible(true);
        ChordEditor ce = new ChordEditor();
        m_frame.getContentPane().removeAll();
        m_frame.add(ce);
        m_frame.getContentPane().repaint();
        m_frame.validate();
    }
}