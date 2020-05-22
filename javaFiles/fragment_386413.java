import java.util.Arrays;
import java.util.Scanner;

public class Item {
    //the properties of an Item

    private int priority;
    private String name;
    private double price;

    //default constructer
    public Item() {
        priority = -1;   //fill with default values
        price = 0.0;
        name = "No name yet";
    }
    //constructer with all fields given

    public Item(int priority, String name, double price) {
        this.priority = priority; //there are two instances of each variable
        this.name = name;         // use 'this.' to distinguish them
        this.price = price;
    }
    // all getters simply will return the corresponding field

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        //priority must be between 0 and 7
        if (priority >= 0 && priority <= 7) {
            this.priority = priority;
        } else {
            //otherwise default to 0
            this.priority = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //no constraints on the name so simply assign it
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //price between 0 and 100 inclusive
        if (price >= 0) {
            if (price <= 100) {
                this.price = price;
            } else {
                //use System.err for errors
                // used nested ifs so you can tell if price is to high or low 
                //otherwise it is a bit ambiguous
                System.err.println("Error: price to high");
            }
        } else {
            System.err.println("Error: price to low");
        }
    }
    //your tostring is fine
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Item [getPrice()=").append(getPrice()).append(", ");
        if (getName() != null) {
            builder.append("getName()=").append(getName()).append(", ");
        }
        builder.append("getPriority()=").append(getPriority()).append("]");
        return builder.toString();
    }

    //just put your main here
    //if you can't then put it in a class but don't sub-class this class
    public static void main(String[] args) {
        //put your list declaration here
        //it doesn't quitemake sense for the Item calss to have a field
        //called list in this instance
        Item[] list = new Item[7];
        Scanner keyboard = new Scanner(System.in);
        //i is the most commonly used variable for 'for' loops
        for (int i = 1; i <= list.length; i++) {
            //create a new item
            Item anItem = new Item();
            //call your methods on that object to set its fields
            System.out.println("Enter an item you want to add to your list " + i);
            anItem.setName(keyboard.next());

            System.out.println("Enter a price " + i);
            anItem.setPrice(keyboard.nextDouble());

            System.out.println("Enter the priority of the item " + i);
            anItem.setPriority(keyboard.nextInt());

            //use the var i for the position
            //remember to subtract 1 since arrays start at 0 but i starts at 1
            list[i-1] = anItem;
        }
        System.out.println(Arrays.toString(list));
    }
}