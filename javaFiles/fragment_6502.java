import java.util.ArrayList;
import java.util.Random;

public class Catalogue
{
    private Random randomGenerator;
    private ArrayList<Item> catalogue;

    public Catalogue()
    { 
        catalogue = new ArrayList<Item>();
        randomGenerator = new Random();
    }

    public Item anyItem()
    {
        int index = randomGenerator.nextInt(catalogue.size());
        Item item = catalogue.get(index);
        System.out.println("Managers choice this week" + item + "our recommendation to you");
        return item;
    }
}