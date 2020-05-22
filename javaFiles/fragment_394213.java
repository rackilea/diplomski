static final Object anObject = new Object();
    ...

    HashMap<String,Object> map = new HashMap<String,Object>();
    // Share anObject in many threads.
    map.put(anObject);
    ... // add some entries to the hash map 
    ArrayList<String> info = Toolbox.extractInformation(map);