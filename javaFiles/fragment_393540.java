import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Test {

    public static void main(String[] args) {
        JButton btnYes = new JButton("Yes");
        btnYes.setMnemonic('s');
        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent)e.getSource());
                pane.setValue(JOptionPane.YES_OPTION);
            }
        });
        JButton btnNo = new JButton("No");
        btnNo.setMnemonic('o');
        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent)e.getSource());
                pane.setValue(JOptionPane.NO_OPTION);
            }
        });
        JButton[] options = new JButton[] {btnYes, btnNo};

        JOptionPane.showOptionDialog(
                null, 
                "Help", 
                "More", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null, options, btnYes);

    }

    protected static JOptionPane getOptionPane(JComponent parent) {
        JOptionPane pane = null;
        if (!(parent instanceof JOptionPane)) {
            pane = getOptionPane((JComponent)parent.getParent());
        } else {
            pane = (JOptionPane) parent;
        }
        return pane;
    }

}