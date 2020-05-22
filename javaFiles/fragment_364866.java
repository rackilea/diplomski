//combo box, the program hangs I need to close the entire BlueJ. Please take a look what is wrong in my code
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HulaHoops  {

private Scanner inp = new Scanner(System.in);

public static void main(String[]args) {
    EventQueue.invokeLater(new Runnable()
    {
        @Override
        public void run()
        {
            new HulaHoops();
        }
    });
}

public HulaHoops() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    String choices[] = {"Shoes","Comb","Ball"};
    JComboBox combo = new JComboBox(choices);
    combo.setBackground(Color.gray);
    combo.setForeground(Color.red);
    panel.add(combo);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,100);
    frame.setVisible(true);


    combo.addItemListener(new ItemListener () {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            String item = (String)e.getItem();
            if (e.getStateChange () == ItemEvent.SELECTED)
            {
                System.out.println("You chose " +item);
                    if (item.equals("Comb"))
                    {
            Object val = JOptionPane.showInputDialog("Please input quantity of comb"); 
            System.out.println(val);

                        Integer bilang= Integer.valueOf((String)val);
                        int total = bilang * 99;
                        String order = bilang + " " + "Shoes " + "     " + total;
                        System.out.print("" + order);
                    }


            }
    }
    });
    }
}