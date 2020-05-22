import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
public class Letstry { 
    static int score;
    static JFrame frame;
    static JLabel label;
    static JButton button;
    public static void main (String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    } 
    public static void createAndShowGUI() {
        frame = new JFrame("Scity4"); 
        frame.getContentPane().setLayout(new FlowLayout());
        label = new JLabel("Score: ");
        button = new JButton("+10");
        button.addActionListener (new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                score = score + 10;
                label.setText("Score: " + score);
                frame.pack();
            } 
        });
        frame.add(label);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}