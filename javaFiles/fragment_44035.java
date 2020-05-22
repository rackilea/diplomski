public class Giant {
    private Map<Item, Integer> myMap = new HashMap<Item, Integer>();
    public Iterator<Map.Entry<Item, Integer>> getGiantIterator() {
         return myMap.entrySet().iterator();
    }
}