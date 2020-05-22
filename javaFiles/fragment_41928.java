import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class OpenFile {
    public static void main(String[] args) {
        String selectModule = JOptionPane.showInputDialog("Module Input: ");
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(selectModule)));
        } catch (IOException e) {
            content = e.toString();
        }

        final String fileContent = content;

        Runnable r = new Runnable() {
            public void run() {
                JTextArea textArea22 = new JTextArea(fileContent);
                JFrame frame= new JFrame();   
                frame.setTitle("Opening TextFile");
                frame.setSize(600, 400);
                frame.setLocation(200, 200);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);  
                frame.add(textArea22);
            }
        };

        SwingUtilities.invokeLater(r);
    }
}