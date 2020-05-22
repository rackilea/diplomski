import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DisableButtonsInBetween {

    private JFrame frame = new JFrame(getClass().getSimpleName());
    private JButton[][] buttons;

    private int startXCoord = -1;
    private int startYCoord = -1;
    private int endXCoord = -1;
    private int endYCoord = -1;
    private boolean isStartButton = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DisableButtonsInBetween().initializeGui();
            }
        });
    }

    void initializeGui() {
        JPanel gui = new JPanel(new BorderLayout(3, 1));
        // This is the array of the JButtons in the form of a grid
        JPanel pane;
        buttons = new JButton[15][15];

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        pane = new JPanel(new GridLayout(0, 15));

        pane.setBorder(new CompoundBorder(new EmptyBorder(15, 15, 15, 15), new LineBorder(Color.BLACK)));

        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.add(pane);
        gui.add(boardConstrain);

        // The making of the grid
        for (int ii = 0; ii < buttons.length; ii++) {
            for (int jj = 0; jj < buttons[ii].length; jj++) {
                buttons[jj][ii] = new JButton();

                ImageIcon icon = new ImageIcon(new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB));
                buttons[jj][ii].setIcon(icon);
                buttons[jj][ii].addActionListener(listener);

                pane.add(buttons[jj][ii]);
            }
        }

        frame.add(gui);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setVisible(true);
    }

    //The ActionListener is what gets called when you click a JButton
    private ActionListener listener = e -> {
        //These for loops are done to identify which button was clicked.
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (e.getSource().equals(buttons[i][j])) {
                    if (isStartButton) {
                        //We save the coords of the 1st button clicked
                        startXCoord = i;
                        startYCoord = j;
                    } else {
                        //We save the coords of the 2nd button clicked and call the disableButtons method
                        endXCoord = i;
                        endYCoord = j;
                        disableButtons();
                    }
                    isStartButton = !isStartButton;
                    break;
                }
            }
        }
    };

    //This method disables all the buttons between the 2 that were clicked
    private void disableButtons() {
        compareCoords();
        for (int i = startXCoord; i <= endXCoord; i++) {
            for (int j = startYCoord; j <= endYCoord; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    //This method compares the coords if the 2nd button was before (in its coords) than the 1st one it switched their coords
    private void compareCoords() {
        if (endXCoord < startXCoord) {
            int aux = startXCoord;
            startXCoord = endXCoord;
            endXCoord = aux;
        }
        if (endYCoord < startYCoord) {
            int aux = startYCoord;
            startYCoord = endYCoord;
            endYCoord = aux;
        } 
    }
}