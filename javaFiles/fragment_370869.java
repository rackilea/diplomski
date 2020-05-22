package stackoverflow;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class JButtonTimer extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = 500;
    private static final int SCREEN_HEIGHT = 500;

    public JButtonTimer() {
        final JButton clickBtn = new JButton("clickMe");
        clickBtn.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              System.out.println(e.getActionCommand());

          }
        });

        add(clickBtn);

        Timer timer = new Timer(1 * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickBtn.doClick();
            }

        });
        timer.start();


    }


    public Dimension getPreferredSize() {
        return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new JButtonTimer());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}