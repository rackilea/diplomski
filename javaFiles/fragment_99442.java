import javax.swing.*;

public class ssce{
    public static void main(String... args){
        // Declarations
        String string1 = "Eggs";
        String string2 = "Whole Chicken";
        int quantity1 = 100;
        int quantity2 = 25;

        JFrame f = new JFrame("prova");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String[] col = {"Ingredient", "Quantity"};
        Object[][] data = {
            {string1, new Integer(quantity1)},
            {string2, new Integer(quantity2)}
        };
        JTable tb = new JTable(data, col);
        f.add(tb);
        f.setSize(300, 400);
        f.setVisible(true);
    }
}