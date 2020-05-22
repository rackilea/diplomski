public class JLottery2 extends JFrame implements ActionListener
{
     //...
     JCheckBox[] boxes = new JCheckBox [30];
     int[] rand;

     public JLottery2()
     {
         //...
         rand = new int[MAXBOXES];