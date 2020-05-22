import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGui {

    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    private JTextField enterTextField;
    private JButton sevenB, eightB, nineB, divideB, fourB, fiveB, sixB, multiplyB, oneB, twoB, threeB, subtractB, zeroB, dotB, equalsB, addB;

    public CalculatorGui() {
        JFrame frame = new JFrame("Calculator");
        frame.setTitle("Calculator");
        frame.setSize(WIDTH, HEIGHT);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));        
        enterTextField = new JTextField();       

        frame.add(enterTextField, BorderLayout.NORTH);

        sevenB = new JButton("7");
        eightB = new JButton("8");
        nineB = new JButton("9");
        divideB = new JButton("/");
        fourB = new JButton("4");
        fiveB = new JButton("5");
        sixB = new JButton("6");
        multiplyB = new JButton("*");
        oneB = new JButton("1");
        twoB = new JButton("2");
        threeB = new JButton("3");
        subtractB = new JButton("-");
        zeroB = new JButton("0");
        dotB = new JButton(".");
        equalsB = new JButton("=");
        addB = new JButton("+");

        buttonPanel.add(sevenB);
        buttonPanel.add(eightB);
        buttonPanel.add(nineB);
        buttonPanel.add(divideB);
        buttonPanel.add(fourB);
        buttonPanel.add(fiveB);
        buttonPanel.add(sixB);
        buttonPanel.add(multiplyB);
        buttonPanel.add(oneB);
        buttonPanel.add(twoB);
        buttonPanel.add(threeB);
        buttonPanel.add(subtractB);
        buttonPanel.add(zeroB);
        buttonPanel.add(dotB);
        buttonPanel.add(equalsB);
        buttonPanel.add(addB);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CalculatorGui calcu = new CalculatorGui();
    }
}