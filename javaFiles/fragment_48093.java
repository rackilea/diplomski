package roverMars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ArraysGrid extends JPanel {

private static final long serialVersionUID = -464020590200143351L;

final int rows = 50, columns = 50;

static BufferedImage Ahead, Down, Left, Right;


public void ImageLoader() {

    try {
        Ahead = ImageIO.read(this.getClass().getResource("Ahead.png"));
        Down = ImageIO.read(this.getClass().getResource("Down.png"));
        Left = ImageIO.read(this.getClass().getResource("Left.png"));
        Right = ImageIO.read(this.getClass().getResource("Right.png"));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println("Error occured: " + e);
        e.printStackTrace();
    }

}

public void StringArray(String[][] labelText) {
    int x = 1; // increment rows

    for (int i = 0; i < labelText.length; i++) { // x
        for (int j = 0; j < labelText.length; j++) { // y
            labelText[i][j] = Integer.toString(x); // populate string
            x++;
        }
    }
}

public void JLabelArray(JLabel[][] label, String[][] labelText) {

    ImageLoader();

    for (int i = 0; i < label.length; i++) { // x
        for (int j = 0; j < label.length; j++) { // y
            label[i][j] = new JLabel();
            label[i][j].setText(labelText[i][j]);
            label[i][j].setOpaque(true);
        }
    }
    // Testing to see if image appears
    label[0][0] = new JLabel(new ImageIcon(Down));
    label[1][0] = new JLabel(new ImageIcon(Right));

}

// Add Labels to Panel,
public void Grid(JPanel Grid, JLabel[][] label) {

    String x1[][] = new String[rows][columns];
    StringArray(x1);
    JLabelArray(label, x1);

    int gHeight = label.length, gWidth = label.length;
    Grid.setLayout(new GridLayout(gWidth, gHeight));

    for (int i = 0; i < label.length; i++) { // x
        for (int j = 0; j < label.length; j++) { // y
            Grid.add(label[i][j]);

        }
    }
}

public void Frame(JPanel finalPanel, JPanel Grid) {

    // Add Grid to Scroll Pane
    JScrollPane x4 = new JScrollPane(Grid);
    x4.setPreferredSize(new Dimension(700, 700)); // DO NOT DELETE THIS.
    x4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    x4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // Add Scroll Pane to another Panel with the Border
    finalPanel.setBackground(new Color(153, 153, 204));
    finalPanel.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 50));
    finalPanel.add(x4);

}

// This method to button.
public static void setImage(JLabel l) {

    ArraysGrid ag = new ArraysGrid();

    ag.ImageLoader();

    l = new JLabel(new ImageIcon(Left));
}

static JLabel[][] label = new JLabel[50][50];

public static void main(String[] args) {



    ArraysGrid m = new ArraysGrid();


    JPanel grid = new JPanel();
    JPanel final1 = new JPanel();

    m.Grid(grid, label);
    m.Frame(final1, grid);

    JFrame f = new JFrame();
    f.setTitle("Project Testing");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(true);
    f.setVisible(true);
    f.setLocation(650, 50);
    f.setSize(800, 800);
    f.setAlwaysOnTop(true);
    f.setBackground(Color.black);

    f.add(final1);

    JButton button = new JButton("Click Here");

    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0) {
            System.out.println("Clicked");
            label[1][1].setBackground(Color.RED);
            //label[2][1] = new JLabel();
            System.out.println(label[2][1].getIcon());

            setImage(label[2][2]);
            label[2][2].setIcon(new ImageIcon(Ahead)); // This throws several errors

        }
    });

    f.add(button, BorderLayout.NORTH);



    f.pack();

}


}