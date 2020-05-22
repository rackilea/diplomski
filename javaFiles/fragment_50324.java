import javax.swing.JOptionPane;


public class JavaApplication2 {
public static void main(String[] args) {
    int a;
    String number;
    number = JOptionPane.showInputDialog("What is your number");

 //Double d = Double.parseDouble(number);//For Double

 a=Integer.parseInt(number);//Because of you declared a as int

    if ( ( a % 2 ) == 0 )//;
         System.out.println("That is an even number");

    else{
        System.out.println("That is an odd number");
        }
    System.exit(0);
}
}