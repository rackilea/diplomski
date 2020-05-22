import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * @see https://stackoverflow.com/a/22631012/230513
 * @see https://stackoverflow.com/a/22423511/230513
 * @see https://stackoverflow.com/a/12228640/230513
 */
public class ImageShuffle extends JPanel {

    private List<Icon> list = new ArrayList<Icon>();
    private JLabel label = new JLabel();
    private Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    });

    public ImageShuffle() {
        this.setLayout(new GridLayout(1, 0));
        list.add(UIManager.getIcon("OptionPane.errorIcon"));
        list.add(UIManager.getIcon("OptionPane.informationIcon"));
        list.add(UIManager.getIcon("OptionPane.warningIcon"));
        list.add(UIManager.getIcon("OptionPane.questionIcon"));
        label.setIcon(UIManager.getIcon("OptionPane.informationIcon"));

        timer.start();
    }

    private void update() {
        Collections.shuffle(list);
        label.setIcon(list.get(0));
    }

    private void display() {
        JFrame f = new JFrame("ImageShuffle");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.add(label);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ImageShuffle().display();
            }
        });
    }
}