import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Application {

    Application() {
        JFrame f = new JFrame("test");
        //f.setSize(1280,720); f.pack  should automatically set the size  
        f.setResizable(true);
        //f.setLayout(null); do not use null layout
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel UI = new JPanel();  // uses flowlayout by default
        //UI.setBounds(0, 0, 1280, 720); do not set bounds. that the job of the layout manager

        JTextField unscramblee = new JTextField("test", 10);
        //unscramblee.setBounds(240, 200, 400, 50);
        JButton submit = new JButton("Submit");
        //submit.setBounds(240, 350, 400, 100);
        JLabel possibleWordsDisplay = new JLabel("possibleWordsDisplay - this is a display for words that are possible");
        //possibleWordsDisplay.setBounds(240, 0, 200, 200);

        UI.add(unscramblee);
        UI.add(submit);
        UI.add(possibleWordsDisplay);

        JScrollPane scrollPane = new JScrollPane(UI);
        f.getContentPane().add(scrollPane); //uses borderlayout by default 
        f.pack();
        f.setVisible(true); //make frame visible after construction is completed 
    }

    public static void main(String[] args) {
        new Application();
    }
}