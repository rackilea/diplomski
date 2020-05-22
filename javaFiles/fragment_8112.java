import java.util.*;

public class VendingMachine
{

    static List<ShowMenu> menu = new ArrayList<ShowMenu>();

    public static void main(String[] args)
    {

        System.out.println("Please choose from the menu below:");
        for (int i = 0; i < 9; i++)
        {

            String[] item = {"Water", "Coke", "Diet Coke", "Iced Tea", "Swiss Chocolate", "Candy", "Chips",
                             "Bubble Gum", "Turkish Delight"};
            int[] count = {10, 10, 10, 10, 10, 10, 10, 10, 10};
            double[] price = {0.75, 1.20, 1.20, 1.00, 1.50, 0.95, 1.10, 0.50, 1.20};

            ShowMenu items = new ShowMenu(item[i], count[i], price[i]);
            menu.add(items);

        }

        int k = 1;

        for (ShowMenu item : menu)
        {
            System.out.print(k + ".");
            k = k + 1;
            System.out.println(item);
        }
    }
}




import java.util.*;

public class ShowMenu
{

    public String item;
    public int count;
    public double price;

    public ShowMenu(String items, int count, double price)
    {

        this.item = items;
        this.count = count;
        this.price = price;

    }

    public String toString()
    {
        return " " + item + " " + "$" + price;
    }
}