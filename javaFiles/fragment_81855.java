import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class ScrolImg implements Runnable {
    private JFrame  frame;
/* Start 'Runnable' interface methods. */
    public void run() {
        showGui();
    }
/* End 'Runnable' interface methods. */
    private JScrollPane createMainPanel() {
        Icon ico = new ImageIcon("worldmap.jpg");
        JLabel label = new JLabel(ico);
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        return scrollPane;
    }

    private void showGui() {
        frame = new JFrame("ScrolImg");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ScrolImg instance = new ScrolImg();
        EventQueue.invokeLater(instance);
    }
}