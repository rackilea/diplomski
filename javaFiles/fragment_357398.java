import java.awt.*;
import javax.swing.*;

public class First {
    public static void main(String[] args) {
        Color purpleColor = new Color(120, 78, 140);
        Color pinkColor = new Color(120, 13, 14);
        String a ="HELLO";
        // CENTER_BASELINE should not be included in a Font style!
        //Font f1 = new Font(a, Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 25);
        Font f1 = new Font(a, Font.BOLD + Font.ITALIC, 25);
        JFrame f = new JFrame();
        // default layout for a frame is BorderLayout
        // a component added to BL with no constraint will end up in CENTER
        // a component in center will be stretched to available size
        f.setLayout(new GridBagLayout());
        f.setSize(300,200);
        JButton b = new JButton(a);
        // Must set the font! 
        b.setFont(f1);
        // will be (rightly) ignored by layout. Use setMargin(..)
        //b.setSize(400,200); 
        b.setMargin(new Insets(20,20,20,20));
        // Many calls relevant to the content pane of a frame were configured 
        // to pass directly through to it. The BG color was NOT one of them!
        //f.setBackground(pinkColor);
        f.getContentPane().setBackground(pinkColor);
        b.setBackground(purpleColor);
        // AFAIR, necessary for some PLAFs
        b.setContentAreaFilled(false);
        b.setOpaque(true);
        f.add(b);
        // Good practice
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true); 
    }
}