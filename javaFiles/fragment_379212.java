import java.awt.*;
import javax.swing.*;
public class Test {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Scorllbar test");
        JPanel jp = new JPanel() {{ add(new JComponent() {
                { setPreferredSize(new Dimension(450, 450)); }
                public void paintComponent(Graphics g) {
                    g.drawLine(0, 0, getWidth(), getHeight());
                    g.drawLine(getWidth(), 0, 0, getHeight());
                }});}};

        JScrollPane sp = new JScrollPane(jp,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Get the scroll-bar and make it a bit wider.
        JScrollBar sb = sp.getVerticalScrollBar();
        sb.setPreferredSize(new Dimension(50, 0));

        // Put it to the left.
        sp.remove(sb);
        JPanel tmp = new JPanel(new BorderLayout());
        tmp.add(sp, BorderLayout.CENTER);
        tmp.add(sb, BorderLayout.WEST);

        jf.add(tmp);
        jf.setSize(300, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}