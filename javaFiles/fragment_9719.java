import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class MainClass extends JFrame{

    private JFrame frmScms;
    private JTabbedPane tabbedPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainClass window = new MainClass();
                    window.frmScms.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainClass() {
        initialize();
    }

    private void initialize() {
        frmScms = new JFrame();
        frmScms.setTitle("SCMS");
        frmScms.setBounds(100, 100, 1080, 684);
        frmScms.setExtendedState(MAXIMIZED_BOTH);
        frmScms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmScms.getContentPane().setLayout(null);
        frmScms.setResizable(true);

        //Set the frame icon to an image loaded from a file.
        frmScms.setIconImage(new ImageIcon("images/company-logo.gif").getImage());

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(2, 20, 1900, 1080);

        //tool tip for screen-1 to 6
        String tooltip1 = "Screen-1";
        String tooltip2 = "Screen-2";
        String tooltip3 = "Screen-3";


        // Create a tabbed pane
        tabbedPane.addTab("Screen-1", null, new PageScreen1(), tooltip1);
        tabbedPane.addTab("Screen-2", null, new PageScreen2(), tooltip2);
        tabbedPane.addTab("Screen-3", null, new PageScreen3(), tooltip3);
        frmScms.getContentPane().add(tabbedPane);

        //warning message before close using X 
        frmScms.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frmScms.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                JFrame frame = (JFrame)e.getSource();
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the application?", "Please Confirm",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}