import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//a gui element shares its events only with classes that implement Actionlistener interface
public class SimpleGui1 extends JPanel implements ActionListener {    
       JButton button;
       JFrame frame;
       ppanel mypanel;

    public void paintComponent(Graphics g) 
    {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color startColor = new Color(red, green, blue);
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);
        GradientPaint gradient =  new GradientPaint(70,70,startColor, 150,150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70,70,100,100);
    }

    public static void main (String[] args) {
        SimpleGui1 mywindow = new SimpleGui1();
        mywindow.renderWindow();
    }  
    public void renderWindow(){
        frame = new JFrame();
        button = new JButton("click me");

        //register my interest to catch button events
        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, this);

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }   
    //button will call this method when clicked (its the callback)
    public void actionPerformed(ActionEvent event)
    {       
        frame.repaint();
        button.setText("Clicked!!");
    }
}