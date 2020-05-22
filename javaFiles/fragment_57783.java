import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Driver extends JFrame implements ActionListener {
    JFileChooser fileChooser;  // the file chooser
    JButton openButton;  // button used to open the file chooser
    File file; // used to get the absolute path of the file

    public Driver() {
        this.fileChooser = new JFileChooser();
        this.openButton = new JButton("Open");

        this.openButton.addActionListener(this);

        // add openButton to the JFrame
        this.add(openButton);

        // pack and display the JFrame
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fileChooser.showOpenDialog(Driver.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // from your code
                Runtime rt = Runtime.getRuntime();

                try {
                    File file = fileChooser.getSelectedFile();
                    String fileAbsPath = file.getAbsolutePath();

                    Process p = rt.exec("notepad " + fileAbsPath);                        
                } catch (IOException ex) {
                    // Logger.getLogger(NumberAdditionUI.class.getName())
                    // .log(Level.SEVERE, null, ex);
                }
            } else {
                System.exit(1);
            }
        }

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Driver driver = new Driver();
            }
        });
    }

}