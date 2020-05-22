import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private JLabel txtWindow = new JLabel();
    private JButton jb1 = new JButton();
    private JButton jb2 = new JButton();
    private JButton jb3 = new JButton();
    private final Font font = new Font("Serif", Font.PLAIN, 12);

    public Main() {

        //Creating the top panel for the JLabel
        JPanel panelA = new JPanel(new BorderLayout());

        txtWindow.setForeground(Color.white);
        txtWindow.setFont(new Font("", Font.PLAIN, 15));
        final String text = "Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon Mellon";
        txtWindow.setText("<html><div style='text-align: center;'>" + text + "</div></html>");
        txtWindow.setHorizontalAlignment(JLabel.CENTER);
        panelA.setBackground(Color.BLACK);
        panelA.add(txtWindow, BorderLayout.NORTH);


        //Creating the bottom panel for the JButtons
        JPanel panelB = new JPanel(new GridLayout(3, 1, 5, 5));

        //setting up button properties
        jb1.setBackground(Color.BLACK);
        jb2.setBackground(Color.BLACK);
        jb3.setBackground(Color.BLACK);

        jb1.setForeground(Color.white);
        jb2.setForeground(Color.white);
        jb3.setForeground(Color.white);

        jb1.setFocusPainted(false); //Stopping highlighting of button
        jb2.setFocusPainted(false);
        jb3.setFocusPainted(false);

        jb1.setFont(font);
        jb2.setFont(font);
        jb3.setFont(font);


        panelB.setBackground(Color.BLACK);
        panelB.add(jb1);
        panelB.add(jb2);
        panelB.add(jb3);

        setLayout(new GridLayout(2, 1, 0, 0));
        add(panelA);
        add(panelB);

        setTitle("Screen");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }   

    public static void main(String[] args) {
        new Main();
    }
}