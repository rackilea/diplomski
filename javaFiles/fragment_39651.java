import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {

    Frame()
    {
        /////////////////////////////
        setLayout(null);
        ////////////////////////////
        setSize(400,400);
        JButton btn_Login = new JButton("A");
        btn_Login.setBounds(226, 89, 91, 32);
        getContentPane().add(btn_Login);

        JButton btn_Subscribe = new JButton("B");
        btn_Subscribe.setBounds(10, 11, 103, 32);
        getContentPane().add(btn_Subscribe);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Frame();
    }
}