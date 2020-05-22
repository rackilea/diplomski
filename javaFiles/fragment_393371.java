import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestInternalFrame {

    public static void main(String[] args) {
        new TestInternalFrame();
    }

    private JInternalFrame imageFrame;
    private JDesktopPane desktop;

    public TestInternalFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JMenu fileMenu = new JMenu("File");
                JMenuItem newMenu = fileMenu.add("Show...");
                newMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (imageFrame == null || imageFrame.isClosed()) {
                            imageFrame = new JInternalFrame("Image");
                            imageFrame.setIconifiable(true);
                            imageFrame.setMaximizable(true);
                            imageFrame.setClosable(true);
                            imageFrame.setResizable(true);
                            JLabel label = new JLabel(new ImageIcon("..."));
                            imageFrame.add(label);
                            imageFrame.pack();

                            desktop.add(imageFrame);


                            imageFrame.setLocation(0, 0);
                            imageFrame.setVisible(true);
                        }

                        try {
                            imageFrame.setIcon(false);
                            imageFrame.setSelected(true);
                        } catch (PropertyVetoException ex) {
                            ex.printStackTrace();
                        }
                        imageFrame.moveToFront();
                    }
                });

                desktop = new JDesktopPane();

                JMenuBar mb = new JMenuBar();
                mb.add(fileMenu);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setJMenuBar(mb);
                frame.add(desktop);
                frame.setSize(1200, 900);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}