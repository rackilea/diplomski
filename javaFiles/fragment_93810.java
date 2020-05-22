import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SeriesCalc {

    private JFrame frame;

    private JRadioButton iterative;
    private JRadioButton recursive;
    private ButtonGroup group;

    private JLabel label;
    private JLabel resultLabel;

    private JTextField field;
    private JTextField resultField;

    private JButton computeButton;

    private JPanel pane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SeriesCalc().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 5));

        iterative = new JRadioButton("Iterative");
        recursive = new JRadioButton("Recursive");

        group = new ButtonGroup();

        group.add(iterative);
        group.add(recursive);

        computeButton = new JButton("Compute");

        label = new JLabel("Enter \"i\": ");
        resultLabel = new JLabel("Result: ");

        field = new JTextField(5);
        resultField = new JTextField(5);
        resultField.setEnabled(false);

        pane.add(new JLabel(""));
        pane.add(iterative);

        pane.add(new JLabel(""));
        pane.add(recursive);

        pane.add(label);
        pane.add(field);

        pane.add(new JLabel(""));
        pane.add(computeButton);

        pane.add(resultLabel);
        pane.add(resultField);

        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}