import javax.swing.JOptionPane;
public class Pr27
{
    public static void main(String[] args)
    {
       JOptionPane.showMessageDialog(null, "1\n2\n3\n4\n5\n6\n7\n8\n9\n10");
        JOptionPane.showMessageDialog(null, "1 2 3 4 5 6 7 8 9 10");
        String text;
        text = JOptionPane.showInputDialog("Please enter a number: ");
        int f, x;
        //if you wish to loop from 1 to x then f must start at 1 and not 0 because in your loop you print out f before it increases thus it would be 0.
        f = 1;
        x = Integer.parseInt(text);
        StringBuilder sb = new StringBuilder();
        while (f <= x)
        {
            //rather than show a message dialog every iteration append f and a new line to a StringBuilder for later use.
            sb.append(f).append("\n");
            //JOptionPane.showMessageDialog(null, f);
            f++;
        }
        //string builder has a "\n" at the end so lets get rid of it by getting a substring
        String out = sb.substring(0, sb.length() - 1);
        JOptionPane.showMessageDialog(null, out);
    }
}