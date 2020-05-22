import java.util.Arrays;

public class SelectiveSort {

    public static void main(String[] args) {

        Item [] items = new Item [6];
        items[0] = new Item(2, true);
        items[1] = new Item(5, false);
        items[2] = new Item(3, false);
        items[3] = new Item(1, true);
        items[4] = new Item(6, true);
        items[5] = new Item(4, false);

        System.out.println("Before Sorting:");
        // Removed enhanced for loop
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i].getIntValue() + " ");
        }

        // Sorting
        Arrays.sort(items);

        System.out.println("\n\nAfter Sorting:");
        // Removed enhanced for loop
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i].getIntValue() + " ");
        }
        System.out.println();
    }
}

class Item implements Comparable<Item> {

    private int _intValue;
    private boolean _boolValue;

    public Item(int intValue, boolean boolValue) {
        _intValue = intValue;
        _boolValue = boolValue;
    }

    public int getIntValue() { return _intValue; }

    public boolean getBoolValue() { return _boolValue; }

    @Override
    public int compareTo(Item otherItem) {

        // Using explicit comparison
        int boolComparison = (_boolValue == otherItem._boolValue) ? 0 :
            (_boolValue) ? 1 : -1;
        return (boolComparison != 0) ? -boolComparison :
            ( (_intValue == otherItem.getIntValue()) ? 0 :
                (_intValue > otherItem.getIntValue()) ? 1 : -1);
    }
}