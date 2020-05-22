import javax.swing.*;
import java.awt.*;

public class R_L_MenuBar_Demo
{
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> createAndShowGUI());       
    }

    private static void createAndShowGUI()
    {
        JMenuBar mb = new JMenuBar();

        JMenuItem item_1 = new JMenuItem("First Item");
        JMenu menu_2 = new JMenu("Second Menu");
        JMenuItem item_3 = new JMenuItem("First Item in Second");

        menu_2.add(item_3);
        mb.add(item_1);
        mb.add(menu_2);

        //switch the orientation of the menubar to right to left
        JButton btn_r_to_l = new JButton("Switch menubar to r_to_l");
        btn_r_to_l.addActionListener(e -> {
            mb.invalidate();
            mb.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            mb.validate();
        });

        //switch the orientation of the menubar to left to right
        JButton btn_l_to_r = new JButton("Switch menubar to l_to_r");
            btn_l_to_r.addActionListener(e -> {
            mb.invalidate();
            mb.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            mb.validate();
        });

        JFrame frame = new JFrame("R_L_MenuBar");
        frame.setLayout(new FlowLayout());
        frame.add(btn_r_to_l);
        frame.add(btn_l_to_r);
        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200 , 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
   }
}