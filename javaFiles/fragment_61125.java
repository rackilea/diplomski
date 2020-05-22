import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by ----- on 5/19/2017.
 */
public class Window extends JFrame{
    private final double[][] gradientOriginal = new double[][]{
            {0.00,    0.00,    0.00,    0.01,    0.01,    0.01,   0.01,    0.01,    0.01,    0.01,    0.01,    0.01,   0.00,    0.00,    0.00,    0.00},
            {0.01,    0.02,    0.04,    0.07,    0.07,    0.06,   0.03,    0.02,    0.03,    0.06,    0.07,    0.05,   0.02,    0.02,    0.01,    0.01},
            {0.01,    0.06,    0.09,    0.16 ,   0.23 ,   0.17  ,  0.09   , 0.07  ,  0.33   , 0.41  ,  0.43  ,  0.13   , 0.05   , 0.02 ,   0.04  ,  0.01},
            {0.01 ,   0.05  ,  0.14 ,   0.15  ,  0.21  ,  0.26  ,  0.11  ,  0.11  ,  0.43  ,  1.00   , 0.44  ,  0.16 ,   0.05 ,   0.02  ,  0.05  ,  0.01},
            {0.01  ,  0.05  ,  0.08  ,  0.15  ,  0.16   , 0.13  ,  0.09  ,  0.08   , 0.35  ,  0.33 ,   0.32  ,  0.10  ,  0.04  ,  0.00  ,  0.04  ,  0.00},
            {0.01    ,0.03 ,   0.05  ,  0.11    ,0.18  ,  0.17  ,  0.17   , 0.17  ,  0.17  ,  0.17 ,  0.17  ,  0.11  ,  0.05  ,  0.01    ,0.03 ,   0.00},
            {0.01  ,  0.01  ,  0.03  ,  0.06  ,  0.06  ,  0.04   , 0.00 ,   0.00 ,   0.00  ,  0.00   , 0.00 ,   0.00  ,  0.00  ,  0.00 ,   0.00   , 0.00},
    };

    private final int width = gradientOriginal[0].length; //width of our array
    private final int height = gradientOriginal.length; //height of our array
    private final int multiplier = 3; //multiplier to make the output a little brighter
    private final double[][] gradient = new double[height][width]; //our averaged vector
    private final int size = 32; //the size of one of our squares
    private JPanel panel;

    public Window(){
        init();
    }

    private void init(){
        for(int y = 0; y < height; y++){ //loop through every position in the old array, average the surrounding squares, and put it in the new array
            for(int x = 0; x < width; x++){
                int surrounding = 0;
                double total = 0;
                for(int yy = -1; yy <= 1; yy++){
                    for(int xx = -1; xx <= 1; xx++){
                        if(y + yy >= 0 && y + yy < height && x + xx >= 0 && x + xx < width){
                            surrounding++;
                            total += gradientOriginal[y + yy][x + xx];
                        }
                    }
                }
                gradient[y][x] += total / surrounding;
                System.out.println(surrounding);
            }
        }

        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){ //this gets called when we call repaint() later
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                        Rectangle2D rect = new Rectangle2D.Double(x * size, y * size, size, size); //create a rectangle to render
                        int shade = Math.min((int)(gradient[y][x] * 255 * multiplier), 255); //set the color of the rectangle
                        g2d.setColor(new Color(shade, shade, shade)); //also set color of rectangle
                        g2d.fill(rect); //fill in the rectangle
                    }
                }
            }
        };
        panel.setPreferredSize(new Dimension(width * size, height * size)); //some initialization associated with the JPanel and JFrame
        add(panel);
        setResizable(false);
        pack();
        setTitle("Gradient");
        setLocationRelativeTo(null);

    }

    public static void main(String[] args){
        Window myWindow = new Window(); //create a window and set it to be visible  
        myWindow.setVisible(true);
    }
}