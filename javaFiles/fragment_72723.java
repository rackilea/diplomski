import javax.swing.*;
import java.io.IOException;

public class Main {
    static Process proc;

    public static void main(String[] args) {
        try {
            proc = Runtime.getRuntime().exec("Notepad.exe");
        }
        catch(IOException io) {

        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            JButton button = new JButton("Kill");
            frame.add(button);
            button.addActionListener(e -> {
                proc.destroyForcibly();
            });
            frame.pack();
            frame.setVisible(true);
        });
    }
}