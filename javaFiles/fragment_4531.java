public Map<Integer, News> getPartListOfNews(int start, int end) {

    // first, get the range of keys from the original map

    List<Integer> keys = new ArrayList<Integer>();
    for (Integer key : newsList.keySet()) // iterates in insertion order
        keys.add(key);
    List<Integer> subkeys = keys.subList(start, end);

    // now add them in the required order

    Map<Integer, News> tempNewsList = new LinkedHashMap<Integer, News>();
    ListIterator<Integer> iter = subkeys.listIterator();
    while (iter.hasPrevious()) {
        Integer key = iter.previous();
        tempNewsList.put(key, newsList.get(key));
    }

    return tempNewsList;

}