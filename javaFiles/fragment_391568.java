import java.awt.*;
import javax.swing.*;

public class MainSwing extends JFrame {

    public static void main(String[] args) {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Test");
            UIManager.put("ScrollBarUI", "main.CustomScrollBarUI");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace(); // more info for less LOC!
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame() {

                    Container c = getContentPane();
                    JButton button = new JButton("Hello");

                    {
                        c.setLayout(new GridLayout(0,1));
                        c.add(new JButton("Hi"));
                        button.setText(UIManager.getSystemLookAndFeelClassName());
                        button.setVisible(true);
                        button.setPreferredSize(new Dimension(400, 100));
                        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                        button.setContentAreaFilled(false);
                        button.setBackground(Color.BLACK);
                        button.setForeground(Color.WHITE);
                        button.setOpaque(true);
                        c.add(button);
                    }
                };
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}