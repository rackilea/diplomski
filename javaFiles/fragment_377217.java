import java.awt.EventQueue;
import javax.swing.JFileChooser;

public class Test {
    private static int result;
    public static void main(String[] args) throws Exception {
        EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                String folder = System.getProperty("user.dir");
                JFileChooser fc = new JFileChooser(folder);
                result = fc.showOpenDialog(null);
            }
        });
        System.out.println(result);
    }
}