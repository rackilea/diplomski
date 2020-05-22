HashMap<Integer, ArrayList<Integer>> items = new HashMap<>();

// Given an index, i, and an integer, n 
// (e.g. obtained while looping over your data):

if (items.containsKey(i)){
    // Your HasMap contains an ArrayList at this index / key
    // Add the number to the end of the list

    items.get(i).add(n);

} else {
    // There is no ArrayList stored yet at this index / key
    // Create a new list containing only the number

    ArrayList<Integer> list = new ArrayList<>();
    list.add(n);

    items.put(i, list);
}