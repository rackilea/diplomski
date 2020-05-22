import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

@SuppressWarnings("serial")
public class MainClass extends JFrame {

    private JPanel contentPane;
    static JDesktopPane desktopMain = new JDesktopPane();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainClass frame = new MainClass();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainClass() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1368, 766);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnJinternalframe = new JMenu("Click Here");
        menuBar.add(mnJinternalframe);

        JMenuItem mntmOpenInternalFrame = new JMenuItem("Open Internal Frame");
        mntmOpenInternalFrame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JInternalFrame1 frame = new JInternalFrame1(desktopMain
                        .getPreferredSize());
                frame.setVisible(true);
                Dimension desktopSize = desktopMain.getSize();
                frame.setSize(desktopSize);
                frame.setPreferredSize(desktopSize);
                desktopMain.add(frame);
                dontmoveframe();
            }
        });
        mnJinternalframe.add(mntmOpenInternalFrame);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        desktopMain.setBackground(Color.WHITE);
        contentPane.add(desktopMain, BorderLayout.CENTER);
        desktopMain.setLayout(new CardLayout(0, 0));
    }

    public static void dontmoveframe() {
        try {
            JInternalFrame[] frames = desktopMain.getAllFrames();
            frames[0].setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }

        // Make first internal frame unmovable
        JInternalFrame[] frames = desktopMain.getAllFrames();
        JInternalFrame f = frames[0];
        BasicInternalFrameUI ui = (BasicInternalFrameUI) f.getUI();

        Component north = ui.getNorthPane();
        MouseMotionListener[] actions = (MouseMotionListener[]) north
                .getListeners(MouseMotionListener.class);

        for (int i = 0; i < actions.length; i++) {
            north.removeMouseMotionListener(actions[i]);
        }
    }

}