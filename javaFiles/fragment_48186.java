public static void main(String... arg) {
    HashMap<String, Object> x = new HashMap<String, Object>();
    x.put("second", " ordered!");
    x.put("first", "Correctly");

    LinkedList<String> keys = new LinkedList<String>();
    for(final String f : x.keySet()) {
        keys.add(f);
    }
    Collections.sort(keys, new Comparator<String>() {
        public int compare(String first, String second) {
            // return -1 is "first <  second"
            // return 1  is "first >  second"
            // return 0  is "first == second"
            return first.compareTo(second);
        }
    });

    for(final String f : keys) {
        System.out.print(x.get(f));
    }
    System.out.println();
}