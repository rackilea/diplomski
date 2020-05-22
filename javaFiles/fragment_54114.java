import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Driver extends MathProblems {

    MathProblems problems = new MathProblems();
    private static final Scanner in = new Scanner(System.in);

    String s = "Welcome Students!";
    String b = "Start!";
    private JFrame f;
    private JPanel p;

    JFrame frame = new JFrame();

    JButton b1 = new JButton(b);

    JLabel jl = new JLabel(s);

    int i;

    public Driver () {      
        gui();  
    }

    public void gui() { 
        f = new JFrame("Flash Card Program");       
        p = new JPanel();   
        f.setLayout( new GridLayout( 2, 1 ) );
        f.add(jl);
        f.add(p);
        p.setLayout( new GridLayout( 2, 1 ) );
        p.add(b1);

        jl.setHorizontalAlignment(JLabel.CENTER);

        // pack the frame for better cross platform support
        f.pack();
        // Make it visible
        f.setVisible(true);
        f.setSize(560,400); // default size is 0,0
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(b1.getText().equals("Click For Answer")
                {
                    String s = in.nextLine();
                    int answer = Integer.parseInt(s);
                    String result = problems.checkResult(answer);
                    j1.setText(result);
                    String b = "Next Question";
                    b1.setText(b);
                }
                else
                {
                    problems.run();
                    j1.setText(problems.getQuestion());
                    String b = "Click For Answer";
                    b1.setText(b);

                }
          }
});
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
           public void run() {
                new Driver();
           }
        });
    } // End main Method

} // End class Driver