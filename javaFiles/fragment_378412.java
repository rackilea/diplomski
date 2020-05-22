public static void main(String[] args) throws FileNotFoundException, IOException {
    // HashMap to stock all my items with keys that i will use for minhashing
    HashMap<Integer, String> hmap = new HashMap<>();
    List<List<Integer>> MinHash = new ArrayList<>();

    //to read my sets that i defined
    FileReader in = new FileReader("C:\\test\\items.txt");
    BufferedReader brr = new BufferedReader(in);
    String item;
    int key = 1; //for checking value pairs
    while ((item = brr.readLine()) != null) {
        System.out.println(hmap.containsValue(item));
        if (hmap.containsValue(item)) {//problem
            System.out.println("Item already in my map");
        }
            else{
                hmap.put(key, item);
                key++;
            }
        }
        System.out.print(hmap);
    }
}