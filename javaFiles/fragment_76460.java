import java.awt.*;  
    import javax.swing.*;  
    import java.io.*;
    import java.awt.image.*;
    import javax.imageio.*;

    class MainMenu extends Frame {  
    JLabel picLabel,title;
    JButton button;


     public MainMenu () { 
        JPanel panel = new JPanel(new BorderLayout());
    try{
       BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\seng\\workspace\\FoodOrderingSystem\\ramen-noodles.png"));

       Image scaled = myPicture.getScaledInstance(170,170,Image.SCALE_SMOOTH);
       picLabel = new JLabel(new ImageIcon(scaled));}catch(Exception e){}
       title = new JLabel("898 Food Restaurant"); 
       title.setFont(new Font("Serif",Font.ITALIC+Font.BOLD,18));
       title.setForeground(Color.BLUE);
       button = new JButton("Order Food Now >>");
       panel.add(picLabel,BorderLayout.CENTER);
       panel.add(title,BorderLayout.SOUTH);
       JPanel buttonPanel = new JPanel();
       buttonPanel.add(button);
       add(panel); 
    add(buttonPanel);
       setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));  
       setSize(400,400);  
       setVisible(true);  
    }  

    public static void main(String args[]){  
        MainMenu main = new MainMenu(); 
    }  
    }