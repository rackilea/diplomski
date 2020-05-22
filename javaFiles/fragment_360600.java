import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PongFrame extends JFrame {

    private final JLabel scoreLabel;
    private final JLabel pointsLabel;

    public PongFrame() {

        this.setTitle("Game");
        this.setSize(1100, 600);

        scoreLabel = new JLabel("score");
        pointsLabel = new JLabel("");

        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());

        //create score/menu panel
        JPanel scorePanel = new JPanel();

        scorePanel.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 2));
        labelPanel.add(scoreLabel);
        labelPanel.add(pointsLabel);

        // add the labels to the north
        scorePanel.add(labelPanel, BorderLayout.NORTH);

        // create game panel with a preferred size
        JPanel gameArea = new JPanel() {

            public Dimension getPreferredSize() {

                return new Dimension(800, 600);

            }
        };
        gameArea.setBackground(Color.orange);

        // add the game panel to the west
        con.add(gameArea, BorderLayout.WEST);

        // add the score/menu panel to the center
        con.add(scorePanel, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setPoints(final String labeltext) {
        pointsLabel.setText(labeltext);
    }

    public static void main(final String[] args) {
        PongFrame window = new PongFrame();
        window.pointsLabel.setText("0");
    }

}