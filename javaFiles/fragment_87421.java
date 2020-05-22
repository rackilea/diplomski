import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestApplet extends JApplet{
    public static void main(String[] args){
        new TestApplet();
    }
    public TestApplet(){
        this.setSize(400,400);
        this.add(getCustPanel());
        this.setVisible(true);
    }
    private JPanel getCustPanel() {
        JPanel panel = new JPanel ();
        panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
        addButton ("button1", panel);
        addButton ("button2", panel);
        return panel;
    }
    private void addButton (String text, JPanel container)
    {
        JButton button = new JButton (text);
        button.setPreferredSize (new Dimension(100,20));
        button.setAlignmentX (Component.CENTER_ALIGNMENT);
        container.add (button);
    }

}