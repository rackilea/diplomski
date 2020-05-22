import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JavaApplication1 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame = new JFrame();
                final JDesktopPane desktopPane = new JDesktopPane();
                frame.setTitle("Frame");
                frame.setSize(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final GraphicsDevice device = GraphicsEnvironment
                    .getLocalGraphicsEnvironment().getDefaultScreenDevice();
                device.setFullScreenWindow(frame);
                device.setDisplayMode(new DisplayMode(800, 600, 32, 60));

                JButton btn = new JButton();
                btn.setText("Button");
                JPanel panel = new JPanel();

                panel.add(btn);
                frame.add(panel, BorderLayout.NORTH);
                frame.add(desktopPane, BorderLayout.CENTER);

                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JInternalFrame f = new JInternalFrame();
                        JPanel p = new JPanel();
                        p.setBackground(Color.red);
                        f.setSize(300, 300);
                        f.setResizable(true);
                        f.add(p);
                        f.setVisible(true);
                        desktopPane.add(f);
                    }
                });
            }
        });

    }
}