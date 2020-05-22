import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Try01_JScrollPane extends JFrame {

    private static final long serialVersionUID = 4123186105171813186L;
    private JFrame frame = new JFrame("Try01_JScrollPane");
    private JPanel yellowPanel = new JPanel();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    {
        yellowPanel.setBackground(Color.yellow);
    }
    private JScrollPane scrollPane = new JScrollPane(yellowPanel);

    {
        scrollPane.setPreferredSize(new Dimension(400, 300));
    }
    private AbstractAction increaseAction = new AbstractAction() {
        private static final long serialVersionUID = 1L;

        @Override
        public void actionPerformed(ActionEvent e) {
            yellowPanel.setPreferredSize(
                    new Dimension(yellowPanel.getPreferredSize().width + 100,
                    yellowPanel.getPreferredSize().height + 100));
            yellowPanel.revalidate();
            yellowPanel.repaint();
        }
    };
    private Timer increaseTimer = new Timer(1000, increaseAction);

    public Try01_JScrollPane() {
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
        increaseTimer.start();
        increaseTimer.setRepeats(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Try01_JScrollPane();
            }
        });
    }
}