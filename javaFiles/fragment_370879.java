import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;

public class TestWindow {
    public static void testWindow() {
        // JFrame frame = new JFrame("test");
        final JDialog frame = new JDialog((JFrame) null, "Test", ModalityType.APPLICATION_MODAL);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("this is a test!", SwingConstants.CENTER);
        // text.setBounds(0, 30, 300, 50);

        JButton button = new JButton("Start");
        // button.setBounds(100, 100, 100, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        int eb = 15;
        JPanel panel = new JPanel(new BorderLayout(eb, eb));
        panel.setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
        panel.add(text, BorderLayout.PAGE_START);
        panel.add(button, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        // frame.setSize(300, 200);
        // frame.setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}