import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton uselesButton;
    private JButton autoButton;
    private FlowLayout layout;
    private long counter = 0;
    private javax.swing.Timer timer;

    public Gui() {
        super("Button");
        layout = new FlowLayout(FlowLayout.CENTER);
        setLayout(layout);
        setDefaultCloseOperation(3);
        setSize(300, 300);
        setLocationRelativeTo(null);

        //initialing swing timer
        timer = new javax.swing.Timer(100, getButtonAction());

        autoButton = new JButton("Auto");
        add(autoButton);
        autoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!timer.isRunning()) {
                    timer.start();
                } else {
                    timer.stop();
                }
            }
        });
    }

    private ActionListener getButtonAction() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoButton.setText(String.format("Pressed %d times", ++counter));
                if (counter > 1000) {
                    timer.stop();
                }
            }
        };
        return action;
    }

    public static void main(String... args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
}