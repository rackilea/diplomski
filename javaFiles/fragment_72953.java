import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.image.*;
public class Arrangement {



public void main(String[] args) {
    JFrame f= new JFrame();
    f.setVisible(true);
    f.setSize(600,400);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel p = new JPanel (new GridBagLayout());//in the constructor u specify the layout :)
    JPanel a = new JPanel (new GridBagLayout());
    Arrangement arr= new Arrangement();
    for(int j=0;j<16;j++){
       if(j==0)
        Image img= new ImageIcon(arr.getClass().getResource("/Red.png")).getImage();
//Supposing you followed the link and created the class
       buttons[j]= new RoundButton("Button "+(j+1));
    }

    GridBagConstraints c= new GridBagConstraints();
    GridBagConstraints d= new GridBagConstraints();

    c.insets = new Insets(5,5,5,5);//spacing

    for(int j=0;j<8;j++){
       arr.pack(c, 0, j+1,buttons[j],p);
    }
    d.insets = new Insets(5,5,5,5);

    for(int j=0;j<8;j++){
       arr.pack(d, 0, j+9,buttons[j+8],a);
    }


    f.add(p, BorderLayout.WEST);
    f.add(a, BorderLayout.EAST);

}
void pack(Insets target, int xCoord,int yCoord,Component comp, Panel container ){
target.gridx=xCoord;
target.gridy=yCoord;
container.add(comp, target);
}