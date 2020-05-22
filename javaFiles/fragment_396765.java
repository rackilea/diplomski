import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JEditorPaneBorderExample {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setSize(400, 300);
        JPanel panel = new JPanel(new FlowLayout());
        jFrame.setContentPane(panel);

        JEditorPane editor = new JEditorPane();
        new JEditorPaneBorderExample().remove_border(editor);
        panel.add(editor);

        jFrame.setVisible(true);
    }

    private Border b = new LineBorder(Color.black, 1);

    void remove_border(JEditorPane com) {
        com.setBorder(b);
    }

}