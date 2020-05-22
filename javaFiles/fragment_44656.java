import javax.swing.JFileChooser;

public class FChoose {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() { public void run() {
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                java.io.File f = chooser.getSelectedFile();
                System.err.println(f.getPath());
            }
        }});
    }
}