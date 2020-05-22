public static void main(String[] args) {

    //setup
    ArrayList<String> storage;

    storage = new ArrayList<String>(Arrays.asList("4","5","6"));

    String[] data = {"1","2","3"};

    printMe(storage);

    //append
    storage.addAll(0, Arrays.asList(data));

    printMe(storage);
}

public static void printMe(ArrayList<String> strs) {
    System.out.println(Arrays.toString(strs.toArray(new String[0])));
}