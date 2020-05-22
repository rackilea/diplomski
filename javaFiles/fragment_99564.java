public void foo(){

    // Use a TreeMap. It will sort keys on insertion.
    Map<Integer,String> nameByNumber = new TreeMap<>();
    nameByNumber.put(1, "James Boggs");
    // etc. put all the entries in however you need to
    List<Integer> sortedNumbers = personByNumber.getKeys();
    List<String> namesSortedByNumber = personByNumber.getNames();

}