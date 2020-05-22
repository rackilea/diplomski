import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FileChooserFrame extends JFrame {

    public FileChooserFrame() {//construct a JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); //maximize to full screen

        //constract japnel. apply a border layout manager to it
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel); //add panel to frame

        JFileChooser fc = new JFileChooser(); //construct file chooser
        mainPanel.add(fc, BorderLayout.CENTER); //add it to panel
        setVisible(true);
    }

    public static void main(String[] args) {

        new FileChooserFrame();
    }
}