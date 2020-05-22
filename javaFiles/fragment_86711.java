import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Demo {
    JFrame frame;
    JButton nextButton = new JButton ("Next Screen");
    PanelOne p = new PanelOne();
    public void setup() {
        frame = new JFrame();
        frame.setVisible(true);

        frame.add(p);
        frame.pack();
    }


    public class PanelOne extends JPanel { {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Label One"));
        this.add(new JLabel("Label Two"));
        this.add(new JLabel("Label Three"));
        this.add(new JLabel("Label Four"));
        this.add(new JLabel("Label Five"));
        JButton button = new JButton("Next Screen");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                swapPanel();
            }
        });
        this.add(button);
    } }
    public class PanelTwo extends JPanel {{
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JButton("Button One"));
        this.add(new JButton("Button Two"));
        this.add(new JButton("Button Three"));
        this.add(new JButton("Button Four"));
        this.add(new JButton("Button Five"));
    }}


    protected void swapPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {


                frame.remove(p);
                frame.add(new PanelTwo());
                frame.invalidate();
                frame.revalidate();

            }

        });

    }

    public static void main (String[] args) {
        Demo demo = new Demo();
        demo.setup();
    }
}