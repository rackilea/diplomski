import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

class RandListener implements ActionListener
{
    private final JTextField[] tF;

    public RandListener(JTextField[] tF)
    {
        this.tF = tF; // I simplified your code here
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("bRand"))
        {
            for(int k = 0; k < tF.length; k++)
            {
                Random rNum = new Random();
                tF[k].setText(rNum.nextInt() + ""); // Not sure if you wanted a random number..
            }
        }
        if(e.getActionCommand().equals("bMaxMin"))
        {

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}