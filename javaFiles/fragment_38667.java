import java.io.File;

import javax.swing.JFileChooser;

public class Main {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File f1 = fc.getSelectedFile();
        fc.showOpenDialog(null);
        File f2 = fc.getSelectedFile();
        System.out.println(f1.getName());
        System.out.println(f2.getName());
        /* make sure to make some checks to the files f1, f2 */
    }
}