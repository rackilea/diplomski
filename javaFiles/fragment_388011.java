import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MyPanel extends JPanel {

    public MyPanel() {
        setPreferredSize(new Dimension(300, 250));
    }

@Override
public void paintComponent(Graphics g) {

        super.paintComponents(g);
        int width = getWidth()/2;
        int top = (getHeight() - HEIGHT) / 2;
        g.setColor(Color.RED); //need to apply color before painting
        g.fillOval(width, top, 150, 150);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new MyFrame());
    }
}

class MyFrame extends JFrame{

    private JButton btnLeftMvmt, btnRightMvmt;

    public MyFrame() {

        setTitle("Red Oval Translator");
        setLayout(new BorderLayout()); //BorderLayout for JFrame
        JPanel panel2 = new JPanel();
        btnLeftMvmt = new JButton("Left Translation");
        btnRightMvmt = new JButton("Right Translation");
        panel2.add(btnLeftMvmt);
        panel2.add(btnRightMvmt);

        add(new MyPanel());
        add(panel2, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}