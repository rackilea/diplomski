// method to sort by item price and display
public static void sortPrice(Item[] array) {
    Arrays.sort(array, new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.getitemPrice(), o2.getitemPrice());
        }
    });
    printArr(array);
}