import java.awt.BorderLayout;
import javax.swing.*;

public class FrameCloseButtonsByLookAndFeel {

    FrameCloseButtonsByLookAndFeel() {
        String[] names = {
                UIManager.getSystemLookAndFeelClassName(), 
                UIManager.getCrossPlatformLookAndFeelClassName()
        };
        for (String name : names) {
            try {
                UIManager.setLookAndFeel(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // very important to get the window decorations.
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame f = new JFrame(UIManager.getLookAndFeel().getName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel gui = new JPanel(new BorderLayout());
            f.setContentPane(gui);

            JTree tree = new JTree();
            tree.setVisibleRowCount(4);
            gui.add(tree, BorderLayout.LINE_START);

            gui.add(new JScrollPane(new JTextArea(3,15)));

            JToolBar toolbar = new JToolBar();
            gui.add(toolbar, BorderLayout.PAGE_START);
            for (int ii=1; ii<5; ii++) {
                toolbar.add(new JButton("Button " + ii));
                if (ii%2==0) {
                    toolbar.addSeparator();
                }
            }

            f.pack();

            f.setLocationByPlatform(true);
            f.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameCloseButtonsByLookAndFeel();
            }
        });
    }
}