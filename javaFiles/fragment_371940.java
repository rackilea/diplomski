import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Scoreboard extends JPanel{


    JLabel scoreLabel;
    JLabel coord;
    JLabel title;
    JButton quit;
    private final int W = 490;
    private final int H = 400;

    public Scoreboard (int score){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(W, H));
        setBackground(Color.BLUE);
        title = new JLabel("My Title");
        //if you use images in your SO posted code use web links
        //title.setIcon(new ImageIcon("C:\\Users\\Rachel\\Workspace\\Assignment2\\Planet1.png"));
        //title.setSize(200,200); run the code without it and see it has no effect
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add (title,BorderLayout.NORTH);

        scoreLabel = new JLabel("Score: "+Integer.toString(score));
        scoreLabel.setSize(200,200);
        scoreLabel.setBackground(Color.BLUE);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 40));
        scoreLabel.setForeground(Color.WHITE);
        //this is directly related to your question. You can't add 2 components 
        //to the center. 
        //instead add a JPanel to the center, apply a layout manager to it,
        //and add scorelabel and quit button to that JPanel 
        add(scoreLabel, BorderLayout.CENTER);

        coord = new JLabel ("Click the aliens!");
        //coord.setSize(200,400); run the code without it and see it has no effect
        coord.setBackground(Color.RED);
        coord.setOpaque(true); //if you want the color show
        coord.setHorizontalAlignment(SwingConstants.CENTER);
        coord.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        coord.setForeground(Color.WHITE);
        add(coord,BorderLayout.SOUTH);

        JButton quit = new JButton ("Quit Game");
        //no need to set bounds. That is what the layout manager does
        //quit.setBounds(20,30,50,30); 
        quit.setHorizontalAlignment(SwingConstants.CENTER);
        add(quit, BorderLayout.CENTER);
    }

    //add main to your questions to make it runnable 
    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new Scoreboard(50);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}