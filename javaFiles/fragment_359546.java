// method to sort by item name and display
public static void sortName(Item[] itemObject) {
    Arrays.sort(itemObject, new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getitemName().compareTo(o2.getitemName());
        }
    });
    printArr(itemObject);
}