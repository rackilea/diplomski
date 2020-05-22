import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import ch.randelshofer.quaqua.QuaquaManager;

public class SheetTest implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SheetTest());
    }

    @Override
    public void run() {
        try {
            QuaquaManager.setExcludedUIs(new HashSet<>(Arrays.<String>asList(
                "RootPane"
            )));
            UIManager.setLookAndFeel(QuaquaManager.getLookAndFeel());
        } catch (Exception ignored) {}

        JButton button = new JButton("Sheet me!");
        JToolBar toolBar = new JToolBar();
        JScrollPane content = new JScrollPane();
        JFrame frame = new JFrame();

        toolBar.setFloatable(false);
        toolBar.setOpaque(false);
        toolBar.add(button);

        frame.setLayout(new BorderLayout());
        frame.add(toolBar, BorderLayout.PAGE_START);
        frame.add(content, BorderLayout.CENTER);
        // Under current Aqua L&F, this doesn't actually look like brushed metal.
        // It looks like normal window titles.
        frame.getRootPane().putClientProperty("apple.awt.brushMetalLook", true);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}