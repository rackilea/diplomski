import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardGUI extends JFrame {

   private JButton a = new JButton("Undo");
   private  JButton r = new JButton("replay");
   private  JPanel jp = new JPanel();

    public BoardGUI() {
        setTitle("Checkers Game");
        jp.setLayout(new FlowLayout());
        jp = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(new Dimension(645, 35));
            }

           /* @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //
            }*/
        };
        jp.add(a);
        jp.add(r);
        add(jp, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BoardGUI();
            }
        });
    }
}