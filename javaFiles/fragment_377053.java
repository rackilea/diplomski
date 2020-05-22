private List<Session> sessions() {
    Cache<Integer, List<Session>> c = myCache.getCache("sessions");
    // since you List is not a HashMap, you will need to make sure that
    // you get this right
    List<Session> l = c.get(1); // this returns the List, but with the key 1, read all the code, you will understand
    if (l != null) { // if its ok, then return the list
        return l;
    } else { // you need to make sure the list exist in the cache, just for the first time, all the other times, l will be different then null
        l = new ArrayList<Session>(); // make an empty list
        c.put(1, l); //add it to the cache
        return l; // use the list as you wish
    }
}