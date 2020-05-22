import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//public class Test extends JFrame {
public class Test {

    private JTextField num3;
    private JLabel label3;
    private JButton button;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private ButtonGroup radioGroup;

    private JList statesList;

    String[] states = {"Alabama",   "Alaska",   "Wyoming"};
    String expression;
    String frequency;

    // no args constructor
    public Test() {
        createUI();
    }

    private void createUI() {
        JFrame f = new JFrame("Search Engine");
        Container contentPane = f.getContentPane();
        // This needs fixing NEXT!
        contentPane.setLayout(null);

        label3 = new JLabel();
        label3.setText("Search Expression");
        label3.setBounds(16, 120, 200, 21);
        contentPane.add(label3);
        num3 = new JTextField();
        num3.setText("(any expression)");
        num3.setBounds(16, 144, 150, 21);
        num3.setHorizontalAlignment(JTextField.LEFT);
        contentPane.add(num3);

        button = new JButton("Start!");
        button.setBounds(90,430,126,24);
        contentPane.add(button);
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    buttonActionPerformed(event);
                }
            });
        // States Selection
        statesList = new JList(states);
        statesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        statesList.setVisibleRowCount(5);
        statesList.setBounds(400, 16, 100, 50);
        JScrollPane statesScroll = new JScrollPane(statesList);
        statesScroll.setBounds(180, 16, 135, 400);
        contentPane.add(statesScroll);

        // Radio Buttons
        radio2 = new JRadioButton();
        radio3 = new JRadioButton();
        radio3.setSelected(true);

        radioGroup = new ButtonGroup();
        radioGroup.add(radio2);
        radioGroup.add(radio3);

        radio2.setText("Quarterly");
        radio3.setText("Yearly");

        radio2.setBounds(16,360,90,23);
        radio3.setBounds(16,385,75,23);

        contentPane.add(radio2);
        contentPane.add(radio3);

        // set the content Pane window
        f.setSize(750,500);
        //f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }

    // Getting the user's TextField and JRadioButton input
    private void buttonActionPerformed(ActionEvent event) {
        expression = num3.getText();
        if (radio2.isSelected())
            frequency = "quarterly";
        else frequency = "yearly";
        System.out.println(expression+","+frequency);

        Object[] values = statesList.getSelectedValues();
        for (Object state : values) {
            System.out.println(state);
        }
    }


    // main thread
    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Test application = new Test();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}