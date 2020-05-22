import java.awt.*;

public class FrameTest {

    public static void setUIFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        setUIFont(new FontUIResource(new Font("Arial", 0, 20)));

        JFrame f = new JFrame("Demo");
        f.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.add(new JLabel("hello"));
        p.setBorder(BorderFactory.createTitledBorder("Test Title"));

        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}