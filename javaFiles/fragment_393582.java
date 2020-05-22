import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Main2 extends JPanel {
    private MenuPanel menuPanel = new MenuPanel(this);
    private GamePanel gamePanel = new GamePanel(this);
    private CardLayout cardLayout = new CardLayout();

    public Main2() {
        setLayout(cardLayout);
        add(menuPanel, MenuPanel.NAME);
        add(gamePanel, GamePanel.NAME);
    }

    public void setDifficulty(Difficulty difficulty) {
        gamePanel.setDifficulty(difficulty);
    }

    public void showCard(String name) {
        cardLayout.show(Main2.this, name);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Main2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

}

@SuppressWarnings("serial")
class MenuPanel extends JPanel {
    public static final String NAME = "menu panel";
    private static final String MAIN_TITLE = "Random Number Guessing Game";
    private static final String SUB_TITLE = "Select a difficulty";
    private static final int GAP = 3;
    private static final float TITLE_SIZE = 20f;
    private static final float SUB_TITLE_SIZE = 16;

    private Main2 main2;

    public MenuPanel(Main2 main2) {
        this.main2 = main2;
        JLabel titleLabel = new JLabel(MAIN_TITLE, SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_SIZE));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        JLabel subTitleLabel = new JLabel(SUB_TITLE, SwingConstants.CENTER);
        subTitleLabel.setFont(subTitleLabel.getFont().deriveFont(Font.PLAIN, SUB_TITLE_SIZE));
        JPanel subTitlePanel = new JPanel();
        subTitlePanel.add(subTitleLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
        for (Difficulty difficulty : Difficulty.values()) {
            buttonPanel.add(new JButton(new DifficultyAction(difficulty)));
        }

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(titlePanel);
        add(subTitlePanel);
        add(buttonPanel);
    }

    private class DifficultyAction extends AbstractAction {
        private Difficulty difficulty;

        public DifficultyAction(Difficulty difficulty) {
            this.difficulty = difficulty;
            String name = String.format("%s (0-%d)", difficulty.getText(), difficulty.getMaxValue());
            putValue(NAME, name);

            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            main2.setDifficulty(difficulty);
            main2.showCard(GamePanel.NAME);
        }
    }


}

enum Difficulty {
    EASY("Easy", 100), MEDIUM("Medium", 1000), HARD("Hard", 10000);
    private String text;
    private int maxValue;

    private Difficulty(String text, int maxValue) {
        this.text = text;
        this.maxValue = maxValue;
    }

    public String getText() {
        return text;
    }

    public int getMaxValue() {
        return maxValue;
    }
}

@SuppressWarnings("serial")
class GamePanel extends JPanel {
    public static final String NAME = "game panel";
    private String labelText = "Guess a number between 0 - ";
    private JLabel label = new JLabel(labelText + Difficulty.HARD.getMaxValue(), SwingConstants.CENTER);
    private Main2 main2;
    GuessAction guessAction = new GuessAction("Guess");
    private JTextField textField = new JTextField(10);
    private JButton guessButton = new JButton(guessAction);
    private boolean guessCorrect = false;

    private Difficulty difficulty;

    public GamePanel(Main2 main2) {
        this.main2 = main2;
        textField.setAction(guessAction);

        JPanel guessPanel = new JPanel();
        guessPanel.add(textField);
        guessPanel.add(Box.createHorizontalStrut(10));
        guessPanel.add(guessButton); 

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(guessPanel);

        setLayout(new BorderLayout());
        add(label, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        label.setText(labelText + difficulty.getMaxValue());
    }

    private class GuessAction extends AbstractAction {
        private int attempts = 1;

        public GuessAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO use difficulty and all to check guesses, and reply to user

            // we'll just show the go back to main menu dialog
            guessCorrect = true; // TODO: Delete this later

            if (guessCorrect) {
                String message = "Attempts: " + attempts + ". Play Again?";
                String title = "You've Guessed Correctly!";
                int optionType = JOptionPane.YES_NO_OPTION;
                int selection = JOptionPane.showConfirmDialog(GamePanel.this, message, title, optionType);
                if (selection == JOptionPane.YES_OPTION) {
                    textField.setText("");
                    main2.showCard(MenuPanel.NAME);
                } else {
                    Window window = SwingUtilities.getWindowAncestor(GamePanel.this);
                    window.dispose();
                }
            }

        }
    }

}