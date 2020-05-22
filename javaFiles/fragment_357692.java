import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JOptionPanePrintingInColumns {

    private JPanel pane;
    private String[] oneDArray = new String[] {"1000", "10000", "99999", "23000", "100000"};
    private String[][] twoDArray = new String[][] {
        {"1000", "10000", "99999", "23000", "100000"},
        {"100", "180000", "9999", "3000", "1090000"}, 
        {"111000", "1220000", "9955999", "230100", "1000200"},
        {"10010", "1005400", "9999954", "9", "123"}, 
        {"100430", "1000054", "999", "23123000", "123456789"}
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new JOptionPanePrintingInColumns()::createAndShowGui);
    }

    private void createAndShowGui() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table><tr>");
        for (int i = 0; i < oneDArray.length; i++) {
            sb.append("<td>").append(oneDArray[i]).append("</td>");
        }
        sb.append("</tr></table></html>");
        output = sb.toString();
        JOptionPane.showMessageDialog(new JFrame(), output);

        sb = new StringBuilder();
        sb.append("<html><table cellspacing=10>");
        for (int i = 0; i < twoDArray.length; i++) {
            sb.append("<tr>");
            for (int j = 0; j < twoDArray.length; j++) {
                sb.append("<td>").append(twoDArray[i][j]).append("</td>");
            }
        }
        sb.append("</tr></table></html>");
        output = sb.toString();
        JOptionPane.showMessageDialog(new JFrame(), output);
    }
}