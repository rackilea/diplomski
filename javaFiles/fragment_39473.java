import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends Applet {
    Color clr;
    Choice c = new Choice();

    public void paint(Graphics g){
        clr=new Color(0,68,255);
        setBackground(clr);
        g.setColor(new Color(255,255,255));
        g.drawString("Select between the numbers.",40,10);
    }

    public void init(){
        char x='\n';
        setLayout(null);
        c.add("1");
        c.add("2");
        c.add("3");
        c.addItemListener(new CustomItemListener());
        c.setLocation(100,100);
        add(c);
    }

    class CustomItemListener implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if(e.getSource() == c) {
                if(c.getSelectedItem().equals("1")) {
                    System.out.println("1 is selected in Choice selector c");
                }
            }
        }
    }
}