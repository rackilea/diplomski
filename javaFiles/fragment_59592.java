import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Graphics;

public class Log extends JFrame {
JButton b1;
JLabel l1;
Image bgImage;
JLabel user = new JLabel("User");

JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);
public static void main(String[] args) {
    Log frameTabel = new Log("bg.jpg");
}

Log(String bgImg){
    super("Login Autentification");
    Toolkit tk = Toolkit.getDefaultToolkit();  
    int xSize = ((int) tk.getScreenSize().getWidth());  
    int ySize = ((int) tk.getScreenSize().getHeight());  
    try{
        bgImage = ImageIO.read(new File(bgImg));
    }
    catch(IOException e){}

    setSize(xSize,ySize);
    setLocationRelativeTo(null);
    panel.setLayout (null); 
    setLayout(new BorderLayout());
    JLabel background=new JLabel(new ImageIcon("C:\bg.jpg"));
    add(background);
    background.setLayout(new FlowLayout());


    txuser.setBounds(Math.round(xSize/2) - 75,30,150,20);
    pass.setBounds(Math.round(xSize/2) - 75,65,150,20);
    blogin.setBounds(Math.round(xSize/2) - 40,100,80,20);

    user.setBounds(Math.round(xSize/2) - 150, 30, 50, 20);

    panel.add(user);
    panel.add(blogin);
    panel.add(txuser);
    panel.add(pass);

    getContentPane().add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
public void paint(Graphics g){
    super.paint(g);
    g.drawImage(bgImage, 0, 0, panel);
}
}