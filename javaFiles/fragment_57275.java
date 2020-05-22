import javax.swing.*;

class Tst
{
    public Tst()
    {
        JTextField tf = new JTextField(10);
        tf.setBounds(100 , 100 , 100 , 20 );

        JFrame f = new JFrame();

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.add(tf);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String s[])
    {
        new Tst();
    }
}