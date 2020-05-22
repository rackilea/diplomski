import java.util.ArrayList;
import java.util.List;

class Item {
    private name;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }


public class ItemManager {

    public static List<ArrayList<Item>> megaList;
    public static void main(String args) {

        megaList = new ArrayList<ArrayList<Item>>();

        ArrayList<Item> someItems = new ArrayList<Item>();
        someItems.add(new Item());
        someItems.add(new Item());

        megaList.add(someItems);

        for(ArrayList<Item> list : megaList ) {
            for (Item item : list) {
                String nameOfItem = item.getName();
            }
        }
    }