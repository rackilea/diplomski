import java.awt.FlowLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame; 
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Spelling extends JFrame {

    private static final long serialVersionUID = 1L;

    JFrame frame = new JFrame();
    JButton button1;

    public Spelling() {
        super("Questionss");
        setLayout(new FlowLayout());

        button1 = new JButton("Spelling game");
        add(button1);

        HandlerClass handler = new HandlerClass();
        button1.addActionListener(handler);
    }

    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String answer1 = JOptionPane.showInputDialog("recipracate, reciprocate, reciprokate");
            if ("reciprocate".equals(answer1)) {
                JOptionPane.showMessageDialog(null, "recriprocate is the correct answer"); 
            }
            else {
                JOptionPane.showMessageDialog(null, answer1 + " is the wrong answer"); 
            }

            String answer2 = JOptionPane.showInputDialog("quintessence, quintessance, qwintessence");
            if ("quintessence".equals(answer2)) {
                JOptionPane.showMessageDialog(null, "quintessence is the correct answer");
            }
            else {
                JOptionPane.showMessageDialog(null, answer2 + " is the wrong answer");
            }
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Spelling test = new Spelling();
            test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            test.pack();
            test.setVisible(true);
        });
    }
}