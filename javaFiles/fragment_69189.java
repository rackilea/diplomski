import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class Test extends JFrame {

    public static void main(String[] args) throws Exception {
        Test.createAndShowGUI();
    }

    private static void createAndShowGUI() throws IOException {

        JFrame.setDefaultLookAndFeelDecorated(true); 

        JFrame frame = new JFrame("HelloWorldSwing");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String imgsrc = 
            Test.class.getClassLoader().getSystemResource("a.jpg").toString();
        frame.getContentPane().add(new JEditorPane("text/html",
            "<html><img src='"+imgsrc+"' width=200height=200></img>"));
        frame.pack();

        frame.setVisible(true);
    }
}