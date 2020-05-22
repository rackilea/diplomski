import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoxTest extends JPanel{

    JButton jbt1 = new JButton("Button1");
    JButton jbt2 = new JButton("Button2");
    JButton jbt3 = new JButton("Button3");
    JButton jbt4 = new JButton("Button4");

    public BoxTest(){
        Box box = Box.createVerticalBox();
        box.add(jbt1);
        box.add(jbt2);
        box.add(jbt3);
        box.add(jbt4);

        add(box);  
    }

    public static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.add(new BoxTest());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGui();
            }
        });
    }
}