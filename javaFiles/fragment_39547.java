/** 
 *  Returns a list of lists containing Foo objects.
 */

public List<List<Foo>> getListOfLists() {
    ResultSet rs = // get data from database...
    List<List<Foo>> mainList = new ArrayList<List<Foo>>();
    for (Row r : rs) {
        List<Foo> subList = new ArrayList<Foo>();
        for (Foo f : r.getFooList()) {
            subList.add(f);
        }
        mainList.add(subList);
    }
    return mainList;
}