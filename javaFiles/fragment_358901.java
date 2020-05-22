//clear map
    Iterator<Map.Entry<String, HashSet<Text>>> iter1 = map.entrySet ().iterator ();
    while (iter1.hasNext()) {
        Map.Entry<String, HashSet<Text>> entry = iter1.next();
        iter1.remove();
    }
    map = null;

    //clear newMap
    Iterator<Map.Entry<String, HashSet<Text>>> iter2 = newMap.entrySet ().iterator ();
    while (iter2.hasNext()) {
        Map.Entry<String, HashSet<Text>> entry = iter2.next();
        iter2.remove();
    }
    newMap = null;