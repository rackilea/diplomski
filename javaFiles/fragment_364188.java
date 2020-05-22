import javax.swing.*;
import java.awt.*;

public class FoucsDemo
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new FoucsDemo();
            }
        });

    }

    FoucsDemo()
    {
        JFrame jFrame=new JFrame("Input Verifier");
        jFrame.setLayout(new GridLayout(2,1,1,5));
        JTextField jTextField1=new JTextField(10);
        JTextField jTextField2=new JTextField(10);
        jTextField1.setInputVerifier(new Verify());
        jTextField2.setInputVerifier(new Verify());
        jFrame.add(jTextField1);
        jFrame.add(jTextField2);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    class Verify extends InputVerifier
    {
        @Override
        public boolean verify(JComponent input)
        {
            return !((JTextField) input).getText().equals("");
        }
    }
}