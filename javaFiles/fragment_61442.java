// Don't do this!
Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

// Do this instead (if you don't need synchronized access)
Map<Integer, Integer> ht = new HashMap<Integer, Integer>();

// Or this, if you need synchronized access:
Map<Integer, Integer> ht = 
    Collections.synchronizedMap(new HashMap<Integer, Integer>());