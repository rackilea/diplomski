import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class MainWindow extends JFrame {
    private static final int FRAME_WIDTH = 1024;
    private static final int FRAME_HEIGHT = 600;

    public MainWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-FRAME_WIDTH/2, dim.height/2-FRAME_HEIGHT/2, FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        this.setLayout(new BorderLayout(4, 4));
        //
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("Test"));
        toolBar.add(new JButton("Test"));
        toolBar.add(new JButton("Test"));
        toolBar.add(new JButton("Test"));
        JPanel northPanel = new JPanel();
        northPanel.add(toolBar);
        //
        JPanel southPanel = new JPanel();
        JLabel statusLabel = new JLabel("Test Status...");
        southPanel.add(statusLabel);
        //
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        //
        JPanel westPanel = new JPanel(new BorderLayout());
        JPanel eastPanel = new JPanel(new BorderLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(eastPanel);
        splitPane.setRightComponent(westPanel);
        splitPane.setDividerLocation(250);
        splitPane.setContinuousLayout(true);
        this.add(splitPane, BorderLayout.CENTER);
        //
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("MyNewIdeTabbedPaneTest.java", new JTextArea());
        tabbedPane.addTab("MyFrame.java", new JTextArea());
        tabbedPane.addTab("JButton.java", new JTextArea());
        tabbedPane.addTab("Main.java", new JTextArea());
        tabbedPane.addTab("MyNewIdeTabbedPaneTest.java", new JTextArea());
        tabbedPane.addTab("MyFrame.java", new JTextArea());
        tabbedPane.addTab("JButton.java", new JTextArea());
        tabbedPane.addTab("Main.java", new JTextArea());
        tabbedPane.addTab("MyNewIdeTabbedPaneTest.java", new JTextArea());
        tabbedPane.addTab("MyFrame.java", new JTextArea());
        tabbedPane.addTab("JButton.java", new JTextArea());
        tabbedPane.addTab("Main.java", new JTextArea());
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setAutoscrolls(false);
        //tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT); Also try this in comparison with above line
        westPanel.add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainWindow mw = new MainWindow();
        mw.setVisible(true);
    }
}