import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * <code>TableInLabel</code>.
 */
public class TableInLabel {

    private static final String LEFT = "left part";

    private static final String RIGHT = "right part";

    public static void main(String[] args) {
        String result =
                "<html><table><td width=\"200\"><font style=color:blue>"
                        + LEFT
                        + "</font></td><td>"
                        + RIGHT + "</td></table></html>";
        JLabel lbl = new JLabel(result);
        JFrame frm = new JFrame("Label");
        frm.add(lbl);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}