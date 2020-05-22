import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class Example extends JFrame {

    private final JTabbedPane tabbedPane;
    private final Rectangle bounds;

    public Example() {
        super("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bounds = new Rectangle(0, 0, 500, 500);
        setBounds(bounds);
//      setLayout(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(bounds);

//      JPanel jp = new JPanel();
//      jp.setLayout(null);
//      jp.setBounds(bounds);
//      jp.add(tabbedPane);
//      add(jp);

        add(tabbedPane);

        Timer timer = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    tabbedPane.addTab("NEW" + tabbedPane.getTabCount(), new JPanel());
                }
                tabbedPane.revalidate();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Example e = new Example();
                e.setVisible(true);
            }
        });
    }
}