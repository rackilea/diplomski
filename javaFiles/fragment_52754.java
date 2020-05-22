import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DragDialog extends JDialog {

    private int pointX;
    private int pointY;

    public DragDialog() {
        JLabel backgroundLabel = createBackgroundLabel();
        JTextField textField = createTextField();
        setContentPane(backgroundLabel);
        add(textField);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextField createTextField() {
        final JTextField field = new JTextField(20);
        field.setText("Type \"exit\" to terminate.");
        field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String text = field.getText();
                if ("exit".equalsIgnoreCase(text)) {
                    System.exit(0);
                }
            }
        });
        return field;
    }

    private JLabel createBackgroundLabel() {
        Image image = null;
        try {
            image = ImageIO.read(new URL("http://i.stack.imgur.com/A9zlj.png"));
        } catch (IOException ex) {
            Logger.getLogger(DragDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        JLabel label = new JLabel(new ImageIcon(image));
        label.setLayout(new GridBagLayout());

        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                DragDialog.this.setLocation(DragDialog.this.getLocation().x + e.getX() - pointX,
                        DragDialog.this.getLocation().y + e.getY() - pointY);
            }
        });
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pointX = e.getX();
                pointY = e.getY();
            }
        });

        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DragDialog();
            }
        });
    }
}