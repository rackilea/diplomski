import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame
{
    private JButton btn;
    Object o;

    public Main()
    {
        setLayout(new FlowLayout());

        o = new String("Hello Beautiful!");

        btn = new JButton("Click!");

       //Passing the reference `o` to the constructor
        btn.addActionListener(new JButtonListener(o));

        add(btn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new Test1();
            }
        });
    }

}