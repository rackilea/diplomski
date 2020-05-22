import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Dobbel1 extends JFrame {

    private int[] zijden = {4, 6, 8, 10, 12, 20};
    Random r = new Random();
    private int chosenDiceNumber = 1;
    private int chosenSidesNumber = 4;
    JLabel result = new JLabel();

    public Dobbel1() {
        super("Yahtzee!");
        getContentPane().setLayout(new FlowLayout());


        JComboBox<String> sides = new JComboBox<String>();
        for (int i = 0; i < zijden.length; i++) {
            sides.addItem("" + zijden[i] + " Sides");
        }

        sides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox number = (JComboBox) event.getSource();
                String selectedValue = number.getSelectedItem().toString();
                chosenSidesNumber = Integer.valueOf((selectedValue.split("\\s+"))[0]);
            }
        });

        getContentPane().add(sides);

        JComboBox<String> number = new JComboBox<String>();
        number.addItem("1 Dice");
        number.addItem("2 Dices");
        number.addItem("3 Dices");
        number.addItem("4 Dices");
        number.addItem("5 Dices");
        number.addItem("6 Dices");
        number.addItem("7 Dices");
        number.addItem("8 Dices");

        number.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox number = (JComboBox) event.getSource();
                String selectedValue = number.getSelectedItem().toString();
                chosenDiceNumber = Integer.valueOf((selectedValue.split("\\s+"))[0]);
            }
        });

        getContentPane().add(number);

        JButton button1 = new JButton("Throw!");
        add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder("Rolled: ");

                for (int i=0; i<chosenDiceNumber; i++) {
                    sb.append(getNextValue()).append(", ");
                }
                sb.delete(sb.length()-2, sb.length());
                result.setText(sb.toString());
            }
        });
        add(result);
    }

    public static void main(String[] args) {
        Dobbel1 dobbel = new Dobbel1();
        dobbel.setSize(800, 400);
        dobbel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dobbel.setMinimumSize(new Dimension(300, 100));
        dobbel.setLocation(300, 150);
        dobbel.setVisible(true);
    }

    private int getNextValue() {
        return r.nextInt(chosenSidesNumber) + 1;
    }
}