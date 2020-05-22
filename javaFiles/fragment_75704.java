import javax.swing.JOptionPane;

public class JavaApplication6 {
    public static void main(String[] args) {
        int y = 0;
        char letter = 'e';
        String food = JOptionPane.showInputDialog("Are you curious how many \"e\"s " +
             "there are in your favorite Food? Then Type your favorite food and I " + 
             "will tell you!");  

        for(int x = 0; x < food.length(); x++)
            if(food.charAt(x) == letter)
                y++;

        JOptionPane.showMessageDialog(null, "it has: " + y);
     }
}