// Getting the entry set (not a copy!)
    Set<Entry<String, String>> entries = map.entrySet();

    // Add elements to the map afterwards
    map.put("abc", "def");

    // Check out the entries in the collection
    // (magically containing the elements added after getting the collection)
    System.out.println(entries); // "[abc=def]"