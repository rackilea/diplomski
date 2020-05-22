import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GuiHandler extends JFrame {
    public static void main(String[] args) throws Exception {
        // call UIManager.setLookAndFeel early in application execution
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new GuiHandler();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private final JFileChooser jfc;

    public GuiHandler() {
        this.jfc = new JFileChooser();
        this.jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.jfc.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));

        final JButton button = new JButton("Open XML file");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xmlFilesBrowserActionPerformed();
            }
        });
        add(button);

        pack();
    }

    protected void xmlFilesBrowserActionPerformed() {
        final File xmlFile = getXmlFile();
        if (xmlFile != null) {
            System.out.println(xmlFile); // process XML file
        }
    }

    private File getXmlFile() {
        // At this point we should be on the event dispatch thread,
        // so there is no need to call SwingUtilities.invokeLater
        // or SwingUtilities.invokeAndWait.
        if (this.jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return this.jfc.getSelectedFile();
        }
        return null;
    }
}