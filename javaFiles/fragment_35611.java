import javax.swing.JOptionPane;

public class ParallelArray3 {
   public static void main(String[] args) {
final int Num =10;
int [] Item= {101, 110, 210, 220, 300, 310, 316, 355, 405, 410};
double [] Price= {0.29, 1.23, 3.50, 0.89, 6.79, 3.12, 4.32, 3.6, 8.3, 5.4};

String ItemId = null;
while ((ItemId = JOptionPane.showInputDialog(null, "Please enter your Item ID number: ")) != null)
{
    System.out.println(ItemId);
    boolean correct = false;
    for (int x = 0; x < Item.length; x++)
    {
        if(Integer.parseInt(ItemId)==(Item[x]))
        {
            JOptionPane.showInputDialog(null, "Your Item is: " + Item[x] + "\n" + "the price is: " + Price[x], JOptionPane.INFORMATION_MESSAGE);
            correct = true;
            break;
        }
    }
    if(!correct)
    {
        JOptionPane.showMessageDialog(null, "item ID not found, try again.", "Not found", JOptionPane.INFORMATION_MESSAGE);
          }
       }
    }
 }