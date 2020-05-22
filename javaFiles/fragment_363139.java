import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class JButtonListener implements ActionListener
{
    private Object _obj;

    public JButtonListener(Object obj)
    {
        _obj = obj;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, _obj.toString());
    }
}