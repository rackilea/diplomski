import java.awt.*;
import javax.swing.*;

public class TypeInNames extends JApplet {

    JTextField name1 = new JTextField("Player 1", 35);
    JTextField name2 = new JTextField("Player 2", 35);

    @Override
    public void init() {
        this.getContentPane().setBackground(Color.black);
        Icon myIcon = new ImageIcon("portal-cake.jpg");
        JLabel label = new JLabel(myIcon);
        this.add(label);
        startGame();
    }

    private void startGame() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Player 1:"));
        panel.add(name1);
        panel.add(new JLabel("Player 2:"));
        panel.add(name2);
        int result = JOptionPane.showConfirmDialog(
            this, panel, "Click OK to Start",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Selected:"
                + " " + name1.getText()
                + " " + name2.getText());
        } else {
            System.out.println("Cancelled");
        }
    }
}