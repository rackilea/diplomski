import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GroceryProgram {

    private final static int GROC_SIZE = 6;
    private final List<ItemData> itemData = new ArrayList<ItemData>();

    private void setUpList(){

        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < GROC_SIZE; i++)  {

               System.out.print("\nEnter item name (" + i + ") : ");               
               String name = keyboard.next();

               System.out.print("\nEnter the price of item (" + i + ") : ");
               double cost = keyboard.nextDouble();

               System.out.print("\nEnter Priority Number (" + i + ") : ");
               int priority = keyboard.nextInt();

               ItemData grocItem = new ItemData(name, cost, priority);
               itemData.add(grocItem); // add grocery items to itemData ArrayList
        }

        keyboard.close();
    }

    private void displayListItems(){

        for(ItemData someItem : itemData){
           System.out.println("\nName: " + someItem.getName() + "\tCost: " + someItem.getCost() + "\tPriority: " + someItem.getPriority());
        }

    }

    public static void main(String[] args) {

        GroceryProgram groProgram = new GroceryProgram();
        groProgram.setUpList();
        groProgram.displayListItems();

    }

}