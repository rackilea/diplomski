import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class JInternalFrame1 extends JInternalFrame {

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public JInternalFrame1(Dimension d) {
        setTitle("JInternalFrame1");
        setBounds(0, 0, 1368, 766);
        setVisible(true);
        setSize(d);
        setClosable(true);
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][]"));

        JButton btnClickMe = new JButton("Click Me");
        btnClickMe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component)e.getSource());

                if (container != null)
                {
                    JDesktopPane desktopPane = getDesktopPane();
                    JInternalFrame2 f1 = new JInternalFrame2();
                    desktopPane.add(f1);//add f1 to desktop pane
                    f1.setVisible(true);
                    Dimension desktopSize = getDesktopPane().getSize();
                    f1.setSize(desktopSize);
                    f1.setPreferredSize(desktopSize);
                    MainClass.dontmoveframe();
                } 

            }
        });
        panel.add(btnClickMe, "cell 7 5");

    }

}