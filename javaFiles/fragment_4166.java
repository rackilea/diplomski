import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Test_swingx extends JFrame
{

    public Test_swingx(String p_title)
    {
        this.setTitle(p_title);
        JPanel pan = new JPanel();
        JTextComponent jtf = new JTextField();
        ((JTextField) jtf).setColumns(20);
        List items = new ArrayList();
        items.add("hello");
        items.add("marwen");
        items.add("allooo");
        AutoCompleteDecorator.decorate(jtf, items, false);
        pan.add(jtf);
        this.setContentPane(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(280, 150, 500, 200);     
    }

    public static void main(String[] args)
    {
        Test_swingx tsx = new Test_swingx("helloo swingx");     
        tsx.setVisible(true);
    }

}