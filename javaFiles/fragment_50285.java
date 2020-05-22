import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.sun.jna.platform.WindowUtils;

public class DialogTests extends JDialog {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            System.setProperty("sun.java2d.noddraw", "true");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            new DialogTests().setVisible(true);
        });
    }

    public DialogTests() {
        this.setAutoRequestFocus(false);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setFocusableWindowState(true);
        this.setBackground(new Color(0,255,255,0));
        WindowUtils.setWindowTransparent(this, true);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0,0,0,200));
        contentPane.setPreferredSize(new Dimension(200,200));
        setContentPane(contentPane);
        setBounds(200, 200, 500, 500);

        JLabel label = new JLabel("this is just to see something!");
        label.setForeground(new Color(255,0,0,255));
        contentPane.add(label);

        JButton button1 = new JButton("test button 1");
        button1.setBackground(new Color(0,0,0,0));
        contentPane.add(button1);

        JButton button2 = new JButton("test button 2");
        button2.setBackground(new Color(0,0,0,0));
        contentPane.add(button2);
    }

}