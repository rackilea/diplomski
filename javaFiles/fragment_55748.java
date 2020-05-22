String[][] arr = new String[hashmap.size()][2];
    Set entries = hashmap.entrySet();
    Iterator entriesIterator = entries.iterator();

    int i = 0;
    while(entriesIterator.hasNext()){

        Map.Entry mapping = (Map.Entry) entriesIterator.next();

        arr[i][0] = mapping.getKey().toString();
        arr[i][1] = mapping.getValue().toString();

        i++;
    }