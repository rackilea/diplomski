import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestSend extends JFrame {

    private JPanel names = new JPanel(new GridLayout(0, 1));
    private Map<String, String> mMap = new HashMap<String, String>();

    public TestSend() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(1, 0));
        top.add(new JLabel("Names"));
        top.add(new JLabel("Email"));
        names.add(top);

        mMap.put("yohan", "yy@yahoo.com");
        mMap.put("Gihan", "gihan@yahoo.com");
        mMap.put("Sumi", "sumi@yahoo.com");
        mMap.put("mac", "mac@yahoo.com");
        mMap.put("Jay", "jay@yahoo.com");
        mMap.put("Rom", "rom@yahoo.com");
        mMap.put("shane", "shane@yahoo.com");
        mMap.put("Mafe", "mafe@yahoo.com");
        mMap.put("willi", "willi@yahoo.com");
        for (Map.Entry<String, String> e : mMap.entrySet()) {
            names.add(createPanel(e.getKey(), e.getValue()));
        }

        this.add(new JScrollPane(names));
        this.pack();
        this.setVisible(true);
    }

    private static JPanel createPanel(String s1, String s2) {
        JPanel panel = new JPanel(new GridLayout(1, 0));
        panel.add(new JCheckBox(s1));
        panel.add(new JLabel(s2));
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestSend();
            }
        });
    }
}