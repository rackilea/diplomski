import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class JFileChooserFun {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame myFrame = new JFrame("GUI");
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(400, 300));

            // example using JFileChooser
            panel.add(new JButton(new AbstractAction("Open File Chooser") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int response = fileChooser.showOpenDialog(myFrame);
                    if (response == JFileChooser.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(myFrame, "Cancel Option Chosen, Closing Now");
                        System.exit(-1);
                    }
                }
            }));

            // example using your own *modal* JDialog
            panel.add(new JButton(new AbstractAction("Open My Modal Dialog") {
                private JDialog dialog = null;
                private boolean closeJVM = true;  // if still true when dialog closed, then close application

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dialog == null) {
                        // build dialog in a "lazy" fashion
                        dialog = new JDialog(myFrame, "My Dialog", ModalityType.APPLICATION_MODAL);
                        JPanel dlgPanel = new JPanel();
                        dlgPanel.add(new JButton(new AbstractAction("OK -- close dialog without closing JVM") {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                closeJVM = false; // set this false so application continues to live
                                dialog.dispose();  // close the dialog and recover resources
                            }
                        }));
                        dialog.add(dlgPanel);
                        dialog.pack();
                    }
                    closeJVM = true; // set the field to close the JVM
                    dialog.setLocationRelativeTo(myFrame);
                    dialog.setVisible(true);

                    // boolean set to false if button pressed
                    if (closeJVM) {
                        JOptionPane.showMessageDialog(myFrame, "Dialog Canceled, Closing GUI");
                        System.exit(-1);
                    }
                }
            }));

            myFrame.add(panel);
            myFrame.pack();
            myFrame.setLocationRelativeTo(null);
            myFrame.setVisible(true);

        });
    }
}