import java.awt.BorderLayout;
import javax.swing.*;

public class JNote {

    public JComponent getGui(int rows, int cols) {
        JPanel p = new JPanel(new BorderLayout(2,2));

        p.add(new JLabel("1"), BorderLayout.LINE_START);
        JTextArea ta = new JTextArea(rows, cols);
        JScrollPane sp = new JScrollPane(
                ta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p.add(sp);
        p.add(
            new JLabel("Rows: " + rows + "    " + "Columns: " + cols),
            BorderLayout.PAGE_END);

        return p;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable(){
            public void run() {
                int cols = 20;
                JNote jNote = new JNote();
                for (int rows=6; rows>0; rows-=2) { 
                    JFrame f = new JFrame("jNote " + rows + "x" + cols);
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setLocationByPlatform(true);
                    f.add(jNote.getGui(rows, cols));

                    f.pack();
                    f.setVisible(true);
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}