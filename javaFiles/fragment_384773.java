int countOccurences(Hashtable<String, Integer> table, int value) {
    int count = 0;
    for(String key : table.keySet()) {
        if(table.get(key) == value) {
            count++;
        }
    }
    return count;
}