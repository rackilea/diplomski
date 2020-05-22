import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class HtmlToolTip {

    HtmlToolTip() {
        String attempt1 = "<html>first line 1<Br>========<Br>second line</html>";
        JLabel label1 = new JLabel(attempt1);
        label1.setBorder(new LineBorder(Color.BLACK));

        String attempt2 = "<html><u>first line 2</u><br>second line</html>";
        JLabel label2 = new JLabel(attempt2);
        label2.setBorder(new LineBorder(Color.BLACK));

        String attempt3 = "<html>first line 3<hr>second line</html>";
        JLabel label3 = new JLabel(attempt3);
        label3.setBorder(new LineBorder(Color.BLACK));

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING,5,5));
        p.add(label1);
        p.add(label2);
        p.add(label3);

        JOptionPane.showMessageDialog(null, p);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HtmlToolTip();
            }
        });
    }
}