import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class LostMouseEvent {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
        new LostMouseEvent();
            }
        });
    }

    public LostMouseEvent() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                JPanel panel1 = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(880, 630);
                    }

                };
                JPanel panel2 = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(840, 610);
                    }
                };
                JScrollPane pane = new JScrollPane(panel2);

                panel1.setBorder(BorderFactory.createLineBorder(Color.blue));
                panel2.setBorder(BorderFactory.createLineBorder(Color.green));


                panel1.add(pane);
                frame.add(panel1);

                MouseListener ml=new MyMouseListener();

                //add mouse listener to panel1 and panel2
                panel1.addMouseListener(ml);
                panel2.addMouseListener(ml);

                //alternatively add to pane
                //pane.addMouseListener(ml);

                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    private class MyMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent me) {
            System.out.println(me);
        }
    }
}