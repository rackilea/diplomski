import java.io.File;
import javax.swing.*;

public class QuickTest {

    public static void main(String[] args) throws Exception {
        File[] files = new File(System.getProperty("user.home")).listFiles();
        JFrame f = new JFrame("Faux J-Link");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JEditorPane jep = new JEditorPane();
        f.add(new JScrollPane(jep));        
        f.setSize(600,400);
        f.setLocationByPlatform(true);
        f.setVisible(true);

        JComboBox choices = new JComboBox(files);
        int result = JOptionPane.showConfirmDialog(f, choices);
        if (result==JOptionPane.OK_OPTION) {
            System.out.println("OK");
            File file = files[choices.getSelectedIndex()];
            jep.setPage(file.toURI().toURL());
        }
    }
}