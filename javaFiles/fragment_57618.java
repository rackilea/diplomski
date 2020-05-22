package varie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.util.Collections.shuffle;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MemoryGame extends JFrame {

private JButton exitButton, replayButton;
private JButton[] gameButton = new JButton[16];
private ArrayList<Integer> gameList = new ArrayList<>();
private int counter = 0;
private int[] buttonID = new int[2];
private int[] buttonValue = new int[2];

public static Point getCenterPosition(int frameWidth, int frameHeight) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();

    int x = (dimension.width - frameWidth) / 2;
    int y = (dimension.height - frameHeight) / 2;
    return (new Point(x, y));
}

public MemoryGame(String title) {
    super(title);

    initial();
}

public void initial() {        
    for (int i = 0; i < gameButton.length; i++) {
        gameButton[i] = new JButton();
        gameButton[i].setFont(new Font("Serif", Font.BOLD, 28));
        gameButton[i].addActionListener(new ButtonListener());
    }
    exitButton = new JButton("Exit");
    replayButton = new JButton("Play Again");
    exitButton.addActionListener(new ButtonListener());
    replayButton.addActionListener(new ButtonListener());

    Panel gamePanel = new Panel();
    gamePanel.setLayout(new GridLayout(4, 4));
    for (int i = 0; i < gameButton.length; i++) {
        gamePanel.add(gameButton[i]);
    }

    Panel buttonPanel = new Panel();
    buttonPanel.add(replayButton);
    buttonPanel.add(exitButton);
    buttonPanel.setLayout(new GridLayout(1, 0));

    add(gamePanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    for (int i = 0; i < 2; i++) {
        for (int j = 1; j < (gameButton.length / 2) + 1; j++) {
            gameList.add(j);
        }
    }
    shuffle(gameList);

    int newLine = 0;
    for (int a = 0; a < gameList.size(); a++) {
        newLine++;
        System.out.print(" " + gameList.get(a));
        if (newLine == 4) {
            System.out.println();
            newLine = 0;
        }
    }

}

public boolean sameValues() {
    if (buttonValue[0] == buttonValue[1]) {
        return true;
    }
    return false;
}

public void reset() {        
    for(int i = 0; i< gameButton.length; i++){
        gameButton[i].setEnabled(true);
        gameButton[i].setText("");
        for(ActionListener al : gameButton[i].getActionListeners()){
            gameButton[i].removeActionListener(al);
        }
        gameButton[i].addActionListener(new ButtonListener());
    }
    buttonID = new int[2];
    buttonValue = new int[2];
    counter = 0;
    shuffle(gameList);
    int newLine = 0;
    for (int a = 0; a < gameList.size(); a++) {
        newLine++;
        System.out.print(" " + gameList.get(a));
        if (newLine == 4) {
            System.out.println();
            newLine = 0;
        }
    }
}

private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (exitButton.equals(e.getSource())) {
            System.exit(0);
        } else if (replayButton.equals(e.getSource())) {
            reset();
        } else {
            for (int i = 0; i < gameButton.length; i++) {
                if (gameButton[i].equals(e.getSource())) {
                    gameButton[i].setText("" + gameList.get(i));
                    gameButton[i].setEnabled(false);
                    counter++;

                    if (counter == 3) {
                        if (sameValues()) {
                            gameButton[buttonID[0]].setEnabled(false);
                            gameButton[buttonID[1]].setEnabled(false);
                        } else {
                            gameButton[buttonID[0]].setEnabled(true);
                            gameButton[buttonID[0]].setText("");
                            gameButton[buttonID[1]].setEnabled(true);
                            gameButton[buttonID[1]].setText("");
                        }
                        counter = 1;
                    }
                    if (counter == 1) {
                        buttonID[0] = i;
                        buttonValue[0] = gameList.get(i);
                    }
                    if (counter == 2) {
                        buttonID[1] = i;
                        buttonValue[1] = gameList.get(i);
                    }
                }
            }
        }
    }
}

public static void main(String[] args) {
    int x, y;
    int width = 500;
    int height = 500;

    Point position = getCenterPosition(width, height);
    x = position.x;
    y = position.y;

    JFrame frame = new MemoryGame("Memory Game");
    frame.setBounds(x, y, width, height);

    frame.setVisible(true);
    frame.setResizable(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}