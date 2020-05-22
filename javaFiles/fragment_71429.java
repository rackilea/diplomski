import javax.swing.JFrame;
import javax.swing.JPanel;

public class SomeFrame extends JFrame {

    public SomeFrame(){
         super("something");
            this.setSize(300, 200);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            this.add(panel);

            this.setVisible(true);
    }

}