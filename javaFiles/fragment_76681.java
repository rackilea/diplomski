import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main { //gives questions (source not included, keylistener included (currently not working), actionlistener included)

    static JRadioButton b1;
    static JRadioButton b2;
    static JFrame frame;
    static JPanel panel;
    static JLabel L1;
    static JLabel L2;
    static JTextField tfield;
    static ButtonGroup bg = new ButtonGroup();
    static JButton B1;
    static double tax;

    static boolean married;

    static ArrayList<String> poss_Questions = new ArrayList<String>();

    private static int q=0;
// Only need 2 buttons because there is only one prompt (yes or no)

    public static String getQuestion() {
        String question = "";
        if (q == 0) {
            question = poss_Questions.get(q);
        } else if (q == 1) {
            question = poss_Questions.get(q);
            b1.setVisible(false);
            b2.setVisible(false);
            tfield.setVisible(true);
            B1.setVisible(true);
        } else if (q == 2) {
            doMath();
            question = poss_Questions.get(q);
            tfield.setVisible(false);
            B1.setVisible(false);
            L2.setText(Double.toString(tax)); //fix to make output more good
            L2.setVisible(true);
        }
        q++;
        L1.setLocation(190, 20);
        if (L1.getText().length() > 16) {
            for (int t = 16; t < L1.getText().length(); t++) {
                L1.setLocation(L1.getX() - 1, L1.getY());
            }
        }
        if (L1.getText().length() < 16) {
            for (int z = 16; z > L1.getText().length(); z--) {
                L1.setLocation(L1.getX() + 1, L1.getY());
            }
        }
        return question;
    }

    public static void checkAnswer() {
        if (L1.getText().equals(poss_Questions.get(0))) {
            if (b1.isSelected()) {
                married = true;
            } else if (b2.isSelected()) {
                married = false;
            }
        }
    }

    static int num;

    public static void doMath() {
        if (married) {
            try {
                num = Integer.parseInt(tfield.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a whole number above zero without decimal points, commas", "ERROR", JOptionPane.ERROR_MESSAGE);
                //may work
            }
            if (num > 0 && num <= 16000) {
                tax = num * 0.10; // 10%
            } else if (num > 16000 && num <= 64000) {
                tax = (1600 + (0.15 * (num - 16000)));
            } else if (num > 64000) {
                tax = (8800 + (0.25 * (num - 64000)));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a value greater than 0, without decimal points, and not in a string format", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            }
        } else if (!married) { //if single
            try {
                num = Integer.parseInt(tfield.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a whole number above zero without decimal points, commas", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            //use else if loops and else (else prints out that there was an error)
            if (num > 0 && num <= 8000) {
                tax = num * 0.10; // 10%
            } else if (num > 8000 && num <= 32000) {
                tax = (800 + (0.15 * (num - 8000)));
            } else if (num > 32000) {
                tax = (4400 + (0.25 * (num - 32000)));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a value greater than 0, without decimal points, and not in a string format", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        poss_Questions.add("Are you married?");
        poss_Questions.add("How much do you make? ($$ per year)");
        poss_Questions.add("Here is how much tax will be taken away");

        b1 = new JRadioButton();
        b1.setText("Yes");
        b2 = new JRadioButton();
        b2.setText("No");

        b1.setVisible(true);
        b2.setVisible(true);
        b1.setBounds(75, 150, 200, 30);
        b2.setBounds(300, 150, 200, 30);

        bg.add(b1);
        bg.add(b2);

        B1 = new JButton();
        B1.setText("Submit");
        B1.setVisible(true);
        B1.setLocation(340, 50);
        B1.setSize(75, 25);
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                L1.setText(getQuestion());
            }
        });

        tfield = new JTextField();
        tfield.setVisible(false);
        tfield.setBounds(100, 50, 200, 20);

        L1 = new JLabel();
        L1.setText(getQuestion());
        L1.setSize(400, 20);
        L1.setLocation(10, 20);

        L2 = new JLabel();
        L2.setVisible(false);
        L2.setSize(400, 20);
        L2.setLocation(10, 60);
        L2.setText("Something went wrong");

        JOptionPane.showMessageDialog(null, L2.getX() + " " + L2.getY());

        panel = new JPanel();
        panel.setVisible(true);

        frame = new JFrame();
        frame.setVisible(true);

        frame.add(panel);
        frame.setSize(new Dimension(480, 270));
        frame.setResizable(false);

        panel.add(b1);
        panel.add(b2);
        panel.add(B1);
        panel.add(L1);
        panel.add(tfield);
        panel.add(L2);

        panel.setLayout(null);

    }
}