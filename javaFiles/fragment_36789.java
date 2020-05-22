import java.awt.*;
import javax.swing.*;
import java.util.*;
public class square
{
    JFrame fr=new JFrame("square");
    Random acak=new Random();
    JScrollPane sc;
    int tinggi,lebar;
    JTabbedPane tab=new JTabbedPane();
    gambar()
    {   
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocation(0,0);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setLayout(new GridLayout(1,1));
        tab.addTab("Panel1",new panel1());
        tab.addTab("Gambar",new panel2());
        fr.add(tab);    
        fr.show();
    }
    public static void main(String[] args)
    {
        new square();
    }
}
class panel1 extends JPanel
{
    int x,y;
    panel1()
    {
        x=(int)(Math.random()*500);
        y=(int)(Math.random()*500);
    }
    public void paintComponent(Graphics g3)
    {

        g3.setColor(Color.red);
        g3.fillRect(x,y,x,y);
    }
}
class panel2 extends JPanel
{
    int x,y;
    panel2()
    {
        x=(int)(Math.random()*500);
        y=(int)(Math.random()*500);
    }
    public void paintComponent(Graphics g2)
    {

        g2.setColor(Color.blue);
        g2.fillRect(x,y,x,y);
    }
}