import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedImage img = ImageIO.read(...);
                    ImageShower.show(null, img);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static class ImageShower extends JPanel {

        private JLabel label = new JLabel();

        public ImageShower() {
            setLayout(new BorderLayout());
            add(label);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "close");
            am.put("close", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Window window = SwingUtilities.windowForComponent(ImageShower.this);
                    if (window != null) {
                        window.dispose();
                    }
                }
            });
        }

        public void setImage(Image img) {
            label.setIcon(new ImageIcon(img));
        }

        public static void show(Component owner, Image img) {
            Window parent = null;
            if (owner != null) {
                parent = SwingUtilities.windowForComponent(owner);
            }

            JButton close = new JButton("Close");
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    Window window = SwingUtilities.windowForComponent(btn);
                    if (window != null) {
                        window.dispose();
                    }
                }
            });

            JDialog dialog = new JDialog(parent, Dialog.ModalityType.APPLICATION_MODAL);
            ImageShower shower = new ImageShower();
            shower.setImage(img);
            dialog.add(shower);
            dialog.add(close, BorderLayout.SOUTH);
            dialog.getRootPane().setDefaultButton(close);
            dialog.pack();
            dialog.setLocationRelativeTo(owner);
            dialog.setVisible(true);
        }

    }

}