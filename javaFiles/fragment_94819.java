package turmite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Base extends JPanel implements ActionListener {

    int x = 200        ,
        y = 200        ,
        d = 0          ,
        X = width  - 1 , 
        Y = height - 1 ;

    Color blk = Color.BLACK ,
          wht = Color.WHITE ,
          c                 ;

    private JButton Button;

    public static void main(String[] args)
    {
        new Base();
    }

    final static int width  = 400;
    final static int height = 400;

    BufferedImage img;

    JFrame frame = new JFrame();

    Base() 
    {
        Button = new JButton("Start Loop");
        Button.setPreferredSize(new Dimension(400,20));
        Button.addActionListener(this);
        Button.setActionCommand("");

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);

        setPreferredSize(new Dimension(width, height));

        frame.setBackground(wht);
        frame.setLayout(new BorderLayout());
        frame.add(Button, BorderLayout.SOUTH);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void loop()
    {
        while(true)
        {
            switch (d) 
            {
            case 0 : x++;       break;
            case 1 :      y++;  break;
            case 2 : x--;       break;
            case 3 :      y--;  break;
            default:            break;
            }

            //for 8-directions
            /*switch (d)
            {
            case 0 : x++;       break;
            case 1 : x++; y++;  break;
            case 2 :      y++;  break;
            case 3 : x--; y++;  break;
            case 4 : x--;       break;
            case 5 : x--; y--;  break;
            case 6 :      y--;  break;
            case 7 : x++; y--;  break;
            default: d = 0;     break;
            }*/

            if (x < 0)  x = X;
            if (x > X)  x = 0;
            if (y < 0)  y = Y;
            if (y > Y)  y = 0;

            if (wht.getRGB() == img.getRGB(x , y))
            {
                c = blk;

                if (d == 3)
                    d =  0;
                else 
                    d++;
            }
            else
            { 
                c = wht;

                if (d == 0)
                    d =  3;
                else 
                    d--;
            }

            Graphics g = img.getGraphics();

            g.setColor(c);  //set color
            g.drawRect(x, y, 0, 0);//set pixel
            g.dispose();

            frame.repaint();
            update(getGraphics());
        }

    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        loop();
    }

}