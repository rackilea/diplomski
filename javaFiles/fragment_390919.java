import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Fonts {

    private String[] fnt;
    private JFrame frm;
    private JScrollPane jsp;
    private JTextPane jta;
    private int width = 450;
    private int height = 300;
    private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private Font[] fnts;
    private StyledDocument doc;
    private MutableAttributeSet mas;
    // private String[] fams;
    private int cp = 0;

    public Fonts() {
        jta = new JTextPane();
        doc = jta.getStyledDocument();
        jsp = new JScrollPane(jta);
        jsp.setPreferredSize(new Dimension(height, width));
        fnt = ge.getAvailableFontFamilyNames();
        mas = jta.getInputAttributes();
        for (int i = 0; i < fnt.length; i++) {
            StyleConstants.setBold(mas, false);
            StyleConstants.setItalic(mas, false);
            StyleConstants.setFontFamily(mas, fnt[i]);
            StyleConstants.setFontSize(mas, 16);
            dis(fnt[i]);
            StyleConstants.setBold(mas, true);
            dis(fnt[i] + " Bold");
            StyleConstants.setItalic(mas, true);
            dis(fnt[i] + " Bold & Italic");
            StyleConstants.setBold(mas, false);
            dis(fnt[i] + " Italic");
        }
        frm = new JFrame("awesome");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new BorderLayout());
        frm.add(jsp, BorderLayout.CENTER);
        frm.setLocation(100, 100);
        frm.pack();
        frm.setVisible(true);
    }

    private void dis(String s) {
        try {
            doc.insertString(cp, s, mas);
            doc.insertString(cp, "\n", mas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Fonts fs = new Fonts();
            }
        });
    }
}