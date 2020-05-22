import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HTMLTableColSpan {

    private JComponent ui = null;
    int left = 706;
    int right = 707;
    int up = 708;
    int down = 709;
    int infinity = 8734;

    HTMLTableColSpan() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        StringBuilder sb = new StringBuilder(
                "<html><body style='font-family: san-serif'>");

        sb.append("<table border=1>");

        sb.append("<tr>");
        sb.append(getTableCell("&#" + right + ";", 2, 1));
        sb.append(getTableCell("&#" + down + ";", 1, 2));
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append(getTableCell("&#" + up + ";", 1, 2));
        sb.append(getTableCell("&#" + infinity + ";", 1, 1));
        sb.append("</tr>");

        sb.append("<tr>");
        sb.append(getTableCell("&#" + left + ";", 2, 1));
        sb.append("</tr>");

        sb.append("</table></body></html>");

        ui.add(new JLabel(sb.toString()));
    }

    public JComponent getUI() {
        return ui;
    }

    private static String getTableCell(String data, int colspan, int rowspan) {
        StringBuilder sb = new StringBuilder("<td colspan=");
        sb.append(colspan);
        sb.append(" rowspan=");
        sb.append(rowspan);
        sb.append(" style='font-size: 50px;'>");

        sb.append(data);

        sb.append("</td>");

        return sb.toString();
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                HTMLTableColSpan o = new HTMLTableColSpan();

                JFrame f = new JFrame("HTML Table colspan");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}