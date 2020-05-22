public class Form1 extends JFrame
{
    private static final long serialVersionUID = 1L;
    JFrame frame = new JFrame("TableLayout");
    Container content = frame.getContentPane();//this doesn't work unless I replace "frame" with the key word "this"///
public Form1 ()//constructor
{