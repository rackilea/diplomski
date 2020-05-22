import javax.swing.*;
import java.awt.*;

public class Test
{
    public static void main(String[] args)
    {
        final ImageIcon icon = new ImageIcon("yourimage.imagetype");
        Image image2 = icon.getImage().getScaledInstance(200,200,0);
        String principleInputString = JOptionPane.showInputDialog(null,"Enter the   principle.","Find Interest Rate", JOptionPane.PLAIN_MESSAGE, new ImageIcon(image2),  null, "").toString();
    }
}