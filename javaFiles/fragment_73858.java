import javax.swing.*;
import java.awt.event.*;

public class ChessSplash extends JFrame {
    private final JComboBox<Difficulty> difficultySetting;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChessSplash gui = new ChessSplash();
                gui.setVisible(true);
            }
        });
    }

    public enum Difficulty {
        EASY(1, "Easy"), MEDIUM(2, "Medium"), HARD(3, "Hard");

        private final int intValue;
        private final String stringValue;

        private Difficulty(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    };

    public ChessSplash() {
        super("Chess Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        difficultySetting = new JComboBox<>(Difficulty.values());
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new DifficultyListener());
        JPanel mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.add(difficultySetting);
        mainPanel.add(startButton);
        pack();
    }

    private class DifficultyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Declare AI
            SimpleAiPlayerHandler ai;

            //Declare and Instantiate Chess Game
            ChessGame chessGame = new ChessGame();

            //Human Player is the Object chessGui
            ChessGui chessGui = new ChessGui(chessGame);
            //Assign Human Player to White
            chessGame.setPlayer(Piece.COLOR_WHITE, chessGui);

            //Get the selected difficulty setting
            Difficulty difficulty = (Difficulty)difficultySetting.getSelectedItem();

            //Instantiate Computer AI pass it the maxDepth for use in the constructor
            ai = new SimpleAiPlayerHandler(difficulty.intValue, chessGame);
            //Assign Computer Player to Black
            chessGame.setPlayer(Piece.COLOR_BLACK, ai);
            //Demonstrate the enum combobox works
            System.out.println(difficulty.intValue);

            //Dispose of the splash JFrame
            ChessSplash.this.dispose();

            //Start your game thread (I would probably do something to move this
            //onto the EDT if you're doing this is swing personally
            new Thread(chessGame).start();
        }
    }
}