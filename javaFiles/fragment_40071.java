import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class CalculatorExample {
    private JFrame frame;
    private JTextArea area;
    private JButton[][] digitsButtons, symbolsButtons;
    private String[][] digitsText = {{"7", "8", "9"}, {"4", "5", "6"}, {"1", "2", "3"}, {"0", "="}}; //Looks strange but this will make the button adding easier
    private String[][] symbolsText = {{"+", "*"}, {"-", "/"}, {"(", ")"}, {"^", "←"}};
    private JPanel buttonsPane, areaAndResultsPane, digitsPane, symbolsPane;
    private JLabel label;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorExample().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("Calculator Example");
        area = new JTextArea();
        area.setRows(5);
        area.setColumns(20);
        label = new JLabel("Results go here");
        digitsButtons = new JButton [4][3];
        symbolsButtons= new JButton [4][2];
        areaAndResultsPane = new JPanel();
        areaAndResultsPane.setLayout(new BoxLayout(areaAndResultsPane, BoxLayout.PAGE_AXIS));

        buttonsPane = new JPanel();
        buttonsPane.setLayout(new GridLayout(1, 2, 10, 10));

        digitsPane = new JPanel();
        digitsPane.setLayout(new GridBagLayout());

        symbolsPane = new JPanel();
        symbolsPane.setLayout(new GridLayout(4, 2));

        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < digitsText.length; i++) {
            for (int j = 0; j < digitsText[i].length; j++) {
                digitsButtons[i][j] = new JButton(digitsText[i][j]);
            }
        }

        for (int i = 0; i < symbolsText.length; i++) {
            for (int j = 0; j < symbolsText[i].length; j++) {
                symbolsButtons[i][j] = new JButton(symbolsText[i][j]);
            }
        }

        areaAndResultsPane.add(area);
        areaAndResultsPane.add(label);

        boolean shouldBreak = false;
        for (int i = 0; i < digitsButtons.length; i++) {
            for (int j = 0; j < digitsButtons[i].length; j++) {
                c.gridx = j;
                c.gridy = i;
                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                if (i == 3) {
                    if (j == 1) {
                        c.gridwidth = 2; //This makes the "=" button larger
                        shouldBreak = true;
                    }
                }
                digitsPane.add(digitsButtons[i][j], c);
                if (shouldBreak) {
                    break;
                }
            }
        }

        for (int i = 0; i < symbolsButtons.length; i++) {
            for (int j = 0; j < symbolsButtons[i].length; j++) {
                symbolsPane.add(symbolsButtons[i][j]);
            }
        }

        frame.add(areaAndResultsPane, BorderLayout.NORTH);
        buttonsPane.add(digitsPane);
        buttonsPane.add(symbolsPane);

        frame.add(buttonsPane, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}