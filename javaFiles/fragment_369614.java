for (HashSet set : xxx) {
    // you need to iterate over the elements in your HashSet here and determine which internal Set has the most elements
    for ( Iterator iter = set.iterator(); iter.hasNext();) {
        HashSet innerSet = (HashSet) iter.next();
        // do the size test
     }

}