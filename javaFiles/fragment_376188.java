public class Main {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();

        // put some test items into the list
        Item first = new Item(1, 1);
        Item second = new Item(2, 2);
        Item third = new Item(3, 3);
        Item fourth = new Item(4, 4);
        Item fifth = new Item(5, 5);
        items.add(first);
        items.add(second);
        items.add(third);
        items.add(fourth);
        items.add(fifth);

        // print the list once:
        System.out.println("Original list:");

        items.forEach((Item item) -> {
            System.out.println(item.toString());
        });

        // remove one item using the rearranging method
        removeItemFrom(third, items);

        // print the result
        System.out.println("After rearrangement:");

        items.forEach((Item item) -> {
            System.out.println(item.toString());
        });
    }

    public static void removeItemFrom(Item itemToBeRemoved, List<Item> items) {
        // first remove the desired item
        items.remove(itemToBeRemoved);

        // then sort (if it is already sorted, skip this step)
        // items.sort(/*otherwise sort with a Comparator of your choice*/);

        // define a counter
        int positioner = 1;

        // give every item in the sorted list a new position
        for(Item item : items) {
            // re-set position with a counter
            item.setPosition(positioner);
            positioner++;
        }
    }
}