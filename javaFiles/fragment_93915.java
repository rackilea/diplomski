import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class ScaledImageIcon extends ImageIcon {
    ScaledImageIcon(Image image, int height) {
        super(image.getScaledInstance(-1, height, Image.SCALE_SMOOTH));
    }
}

public class ScalableIcons {

    public static void main(String[] args) throws Exception {
        final Image img1 = ImageIO.read(
                new URL("http://i.stack.imgur.com/gJmeJ.png"));
        final Image img2 = ImageIO.read(
                new URL("http://i.stack.imgur.com/ET1EH.png"));
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new BorderLayout(5,5));

                final JLabel display = new JLabel();
                display.setPreferredSize(new Dimension(410,200));

                ActionListener al = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = e.getActionCommand();
                        switch (s) {
                            case "1":
                                display.setIcon(new ImageIcon(img1));
                                break;
                            case "2":
                                display.setIcon(new ImageIcon(img2));
                                break;
                        }
                    }
                };

                JPanel imageButtons = new JPanel(
                        new FlowLayout(FlowLayout.CENTER,5,5));

                JButton b1 = new JButton( "1", new ScaledImageIcon(img1,40));
                b1.addActionListener(al);
                imageButtons.add(b1);

                JButton b2 = new JButton( "2", new ScaledImageIcon(img2,40));
                b2.addActionListener(al);
                imageButtons.add(b2);

                gui.add(imageButtons, BorderLayout.NORTH);
                gui.add(display, BorderLayout.CENTER);

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}