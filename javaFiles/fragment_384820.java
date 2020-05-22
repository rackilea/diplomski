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
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i].getIntValue() + " ");
        }

        // Sorting
        bubbleSort(items);

        System.out.println("\n\nAfter Sorting:");
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i].getIntValue() + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(Item [] items) {
        int n = items.length;
        do {
            int newN = 0;
            for(int i = 1; i < n; i++) {
                if(compareTo(items[i-1], items[i]) == 1) {
                    Item temp = items[i-1];
                    items[i-1] = items[i];
                    items[i] = temp;

                    newN = i;
                }
            }
            n = newN;
        } while (n != 0);
    }

    public static int compareTo(Item item1, Item item2) {

        int boolComparison = (item1.getBoolValue() == item2.getBoolValue())
                ? 0 : (item1.getBoolValue()) ? 1 : -1;
        return (boolComparison != 0) ? -boolComparison :
            ( (item1.getIntValue() == item2.getIntValue()) ? 0 :
                (item1.getIntValue() > item2.getIntValue()) ? 1 : -1);
    }
}