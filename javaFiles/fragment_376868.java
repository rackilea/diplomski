import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class Driver {

    static Random rand = new Random();
    private static final int GRID_SIZE = 15;

    private int[][] a; //make it a field
    private GUI run; //make it a field
    Color defaultColor;

    //add constructor
    Driver(){

        run = new GUI();
        a = new int[GRID_SIZE][GRID_SIZE];
        defaultColor = run.getBackground();

        //the following code is used twice : use a method
        reDrawGui();

        run.getReset().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                reDrawGui();
            }
        });
    }

    /**
     *
     */
    private void reDrawGui() {

        for(int x = 0; x < a.length; x++) {

            for(int y = 0; y < a[x].length; y++)
            {
                a[x][y] = rand.nextInt(10);
                JButton button = run.getGrid()[x][y];

                switch(a[x][y])
                {
                case 4: button.setBackground(Color.MAGENTA);
                    break;
                case 5: button.setBackground(Color.CYAN);
                    break;
                case 7:
                case 8:
                case 9:button.setBackground(Color.BLACK);
                    break;
                 default : button.setBackground(defaultColor);
                }

            }
        }
        //revalidate and repaint after gui changed
        run.revalidate(); run.repaint();
    }

    public static void main(String[ ] args) {

        //move intialization code to constructor
        new Driver();
    }
}