import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class RandomButtons extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int ROWS = 8;
    private JButton[][] buttons = new JButton[ROWS][ROWS];
    private List<JButton> buttonList = new ArrayList<>();
    private JPanel buttonsPanel = new JPanel(new GridLayout(ROWS, ROWS));


    public RandomButtons() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                // create new JBUtton
                final JButton button = new JButton("Button");
                // put into array
                buttons[i][j] = button;
                // put into ArrayList
                buttonList.add(button);

                // unique value 0 to 63 for each button
                // order it has been created
                final int value = i * ROWS + j;

                // create one of 64 different color hues using value above
                float hue = ((float) value) / (ROWS * ROWS);
                float sat = 0.7f; // reduce sat so we can see text
                float brightness = 1.0f;
                Color color = Color.getHSBColor(hue, sat, brightness);
                button.setBackground(color); // set button's color
                button.addActionListener(e -> {
                    // display the button's order
                    System.out.println("Value: " + value);
                });

            }
        }
        randomizeButtons();

        JButton randomizeButton = new JButton("Randomize");
        randomizeButton.addActionListener(e -> { randomizeButtons(); });
        JButton orderButton = new JButton("Put in Order");
        orderButton.addActionListener(e -> { orderButtons(); });

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(randomizeButton);
        bottomPanel.add(orderButton);

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public void randomizeButtons() {
        buttonsPanel.removeAll(); // remove all buttons
        Collections.shuffle(buttonList); // shuffle the ArrayList

        // re-add the buttons **using the ArrayList**
        for (JButton jButton : buttonList) {
            buttonsPanel.add(jButton);
        }

        // tell JPanel to layout its newly added components
        buttonsPanel.revalidate();
        // and then paint them
        buttonsPanel.repaint();
    }

    public void orderButtons() {
        buttonsPanel.removeAll();  // remove all buttons

        // re-add the buttons **using the 2D array**
        for (JButton[] buttonRow : buttons) {
            for (JButton jButton : buttonRow) {
                buttonsPanel.add(jButton);
            }
        }
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
    }

    private static void createAndShowGui() {
        RandomButtons mainPanel = new RandomButtons();

        JFrame frame = new JFrame("RandomButtons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}