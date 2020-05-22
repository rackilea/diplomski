import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class JavaApplication100 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JavaApplication100().createAndShowUI();
            }
        });
    }

    private void createAndShowUI() {

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(Container contentPane) {
        JPanel mainPanel = new JPanel();

        //create our 2 seperate panels (could be custom ones)
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        //add labels for viewing
        leftPanel.add(new JLabel("LEFT"));
        rightPanel.add(new JLabel("RIGHT"));

        //just so you can see em or they would be small
        leftPanel.setPreferredSize(new Dimension(300, 300));
        rightPanel.setPreferredSize(new Dimension(300, 300));

        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //add panels to split pane
        jsp.add(rightPanel, JSplitPane.RIGHT);
        jsp.add(leftPanel, JSplitPane.LEFT);

        mainPanel.add(jsp);//add splitpane to mainpanel
        contentPane.add(mainPanel);

    }
}