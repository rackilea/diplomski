import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener
{
    private final JButton circleButton, rectangleButton, redButton;
    private final JButton greenButton, blueButton, exitButton;
    private final JTextArea textArea;
    private final JLabel label1;
    private final JPanel colorPane;

    private static final int ROWS = 2, COLS = 3;

    public GUI (String title)
    {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set label's vertical and horizontal position so it appears in the bottom left
        //and and its desired width
        //for more layout flexibility consider warping it in a JFrame
        label1 = new JLabel("current time here");
        label1.setVerticalAlignment(SwingConstants.BOTTOM);
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label1.setPreferredSize(new Dimension(200, 0)); //height is set by the layout manger
        getContentPane().add(label1, BorderLayout.WEST);

        //use a GridLayout for the buttons pane
        colorPane = new JPanel();
        colorPane.setLayout(new GridLayout(ROWS, COLS));
        getContentPane().add(colorPane, BorderLayout.CENTER);//each BorderLayout position can hold ONE component

        redButton = makeButton("Red");
        colorPane.add(redButton);
        greenButton = makeButton("Green");
        colorPane.add(greenButton);
        blueButton = makeButton("Blue");
        colorPane.add(blueButton);
        rectangleButton = makeButton("Rectangle");
        colorPane.add(rectangleButton);
        circleButton = makeButton("Circle");
        colorPane.add(circleButton);
        exitButton = makeButton("Exit");
        colorPane.add(exitButton);

        //set the text area number of columns. Its height is set by the layout manger
        textArea = new JTextArea(0,20);
        getContentPane().add(textArea, BorderLayout.EAST);

        pack();
    }

    private JButton makeButton(String text) {
        JButton b = new JButton(text);
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.addActionListener(this);
        b.setPreferredSize(new Dimension(125, 55)); //set preferred and let Layout manager do its work
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton)e.getSource()).getText()+ " button pressed");
    }

    public static void main(String[] args) {
        new GUI("My Gui").setVisible(true);
    }
}