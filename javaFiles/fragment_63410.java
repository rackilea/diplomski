public TestSearch(List<List<Integer>> dataInput) {
    this.dataInput = dataInput;
    int searchResultIndex = 0;
    minSearchItem = Integer.MAX_VALUE;
    maxSearchItem = Integer.MIN_VALUE;
    for (List<Integer> list : dataInput) {
        for (Integer item : list) {
            if (item > maxSearchItem ) {
                maxSearchItem = item;
            }
            if (item < minSearchItem) {
                minSearchItem = item;
            }
            List searchResultsList = searchResults.get(item);
            if (searchResultsList == null)  {
                searchResultsList = Arrays.asList(null,null,null,null,null);
                searchResults.put(item,searchResultsList);
            }
            if (minimums.get(searchResultIndex) == null) {
                minimums.set(searchResultIndex, item);
            }
            for (int key : searchResults.keySet())  {
                if (key < item && searchResults.get(key).get(searchResultIndex) == null) {
                    searchResults.get(key).set(searchResultIndex,item);
                }
            }
            searchResultsList.set(searchResultIndex,item);
        }
        searchResultIndex++;
    }
}

private List<List<Integer>> dataInput;
private List<Integer> minimums =Arrays.asList(null,null,null,null,null);
private Integer minSearchItem;
private Integer maxSearchItem;
private Map<Integer,List<Integer>> searchResults = new HashMap<Integer,List<Integer>>(15);


public List<Integer> getItem(final Integer x) {
    if (x <= minSearchItem) {
        return minimums;
    }
    if (x > maxSearchItem) {
        return Arrays.asList(null,null,null,null,null);
    }
    List<Integer>outputs =  searchResults.get(x);
    int nextKey = x + 1;
    while (outputs ==  null) {
        outputs = searchResults.get(nextKey);
        nextKey++;
    }
    return outputs;
}

public static void main(String[] args) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(3, 4, 6));
    List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(2, 3, 6));
    List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    List<Integer> list5 = new ArrayList<Integer>(Arrays.asList(4, 8, 13));

    lists.add(list1);
    lists.add(list2);
    lists.add(list3);
    lists.add(list4);
    lists.add(list5);

    TestSearch search = new TestSearch(lists);

    List<Integer> dataOuput = search.getItem(0);

    System.out.println(dataOuput);
}