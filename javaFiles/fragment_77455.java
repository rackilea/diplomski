import java.awt.EventQueue;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class SeaGlassLNFTest {

        private JFrame frame;

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
                        SeaGlassLNFTest window = new SeaGlassLNFTest();
                        window.frame.setLocationRelativeTo(null);
                        //window.frame.pack();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public SeaGlassLNFTest(){
            initialize();
        }

        private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Panel p = new Panel();
            frame.add(p);
        }
}