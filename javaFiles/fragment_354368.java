ArrayList<String> searchedItems = retainsSearched(s.toString()); 
// ...

public  ArrayList<String> retainsSearched(ArrayList<String term) {
    ArrayList<String> stations = new ArrayList<String>();
    for (int i = 0; i < copyList.size(); i++) {
        if (copyList.get(i).toLowerCase().startsWith(term.toLowerCase())) {
            stations.add(copyList.get(i));
        }
    }
}