import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Class extends JFrame
{
    private JButton btn;
    private JTextArea txtArea;

    public static void main(String[] a)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new Class();// Creating an instance of Class
            }
        });
    }

    public Class()
    {
        super("Title");

        initialize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    private void initialize()
    {
        btn = new JButton("Click me");
        txtArea = new JTextArea();

        add(btn, BorderLayout.NORTH);
        add(txtArea, BorderLayout.CENTER);
    }
}