public class JCTest
{
    public static void Clear(JInternalFrame intFrame)
    {
        if (intFrame == null)
            return;
        Container con = intFrame.getContentPane();
        for (Component c : con.getComponents())
        {
            if (c instanceof JTextField)
            {
                JTextField j = (JTextField)c;
                j.setText("");
            }
        }
    }
}